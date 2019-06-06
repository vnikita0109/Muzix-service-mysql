package com.stackroute.repository;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface TrackRepository extends JpaRepository<Track,Integer> {
    @Query("select m from Track m where m.trackName=:name")
    public Track trackByName(String name);
}
