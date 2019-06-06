package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//import javax.annotation.PostConstruct;
import java.util.List;

@CacheConfig(cacheNames = "track")
@Service
@Primary
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;
    String message=null;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

/*
    @PostConstruct
    public void loadData(){
        trackRepository.save(Track.builder().id(5).trackName("Kill this love").comments("Blackpink").build());
        trackRepository.save(Track.builder().id(6).trackName("Russian Roulette").comments("Red velvet").build());
        trackRepository.save(Track.builder().id(7).trackName("Wanna go out").comments("Mont").build());
    }*/

        //remove the hardcoded values

    public void simulateDelay(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cacheable
    @Override
    public List<Track> getAllTracks() {

        simulateDelay();
        List<Track> trackList=trackRepository.findAll();
        return trackList;
    }


    @CacheEvict(allEntries = true)
    @Override
    public Track createTrack(Track track) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack= trackRepository.save(track);

        return savedTrack;

    }

    @Override
    public Track findTrack(Track track) throws TrackNotFoundException {

        Track foundTrack=null;
        if (trackRepository.existsById(track.getId())){
            foundTrack=trackRepository.getOne(track.getId());
        }
        else {
            throw new TrackNotFoundException("Track does not exist");
        }
        return foundTrack;
    }

    @CacheEvict(allEntries = true)
    @Override
    public String deleteTrack(Track track) throws TrackNotFoundException {
        Track existedTrack=null;

        if (trackRepository.existsById(track.getId())){
            trackRepository.deleteById(track.getId());
        }
        else
        {
            throw new TrackNotFoundException("Track does not exist");
        }
        return message;     //return track(object) when deleted and all values should be null
    }

    @CacheEvict(allEntries = true)
    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        Track existingTrack;
        if (trackRepository.existsById(track.getId())){
            track.setComments(track.getComments());
            existingTrack=trackRepository.save(track);
        }
        else
        {
            throw new TrackNotFoundException("Track does not exist");
        }

        return existingTrack;
    }

    @Override
    public Track searchTrack(Track track) throws TrackNotFoundException{        //pass only trackName as parameter
        Track foundTrack=null;

            foundTrack=trackRepository.trackByName(track.getTrackName());


        if (foundTrack==null){
            throw new TrackNotFoundException("Track does not exist");
        }
        return foundTrack;
    }

}
