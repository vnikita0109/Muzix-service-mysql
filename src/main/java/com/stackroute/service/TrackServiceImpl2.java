package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl2 implements TrackService{
    @Override
    public Track createTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track findTrack(Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public String deleteTrack(Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track searchTrack(Track track) throws TrackNotFoundException {
        return null;
    }
}
