package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
@Api(value = "MuzixControllerAPI",produces = MediaType.APPLICATION_JSON_VALUE)

public class TrackController {

    TrackService trackService;
    ResponseEntity responseEntity;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

            //use annotations of swagger for all methods present

    @GetMapping("track")
    @ApiOperation("Get all the tracks here")
    @ApiResponses(value = {@ApiResponse(code=200,message ="OK",response = Track.class)})
    public ResponseEntity<?>getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @PostMapping("track")
    public ResponseEntity<?>saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
            trackService.createTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully created track !", HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("track") //specify the api var
    public ResponseEntity<?>findTrack(@RequestBody Track track) throws TrackNotFoundException {

            trackService.findTrack(track);
            responseEntity=new ResponseEntity<String>("Track found !",HttpStatus.FOUND);

        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> deleteexistingTrack(@RequestBody Track track) throws TrackNotFoundException {
            trackService.deleteTrack(track);
            responseEntity=new ResponseEntity<String>("Track deleted !",HttpStatus.OK);

        return responseEntity;
    }
    @PutMapping("track")     //implement patchmapping for partial changes
    public ResponseEntity<?>updateexistingTrack(@RequestBody Track track) throws TrackNotFoundException {
        trackService.updateTrack(track);
        responseEntity=new ResponseEntity<String>("Track updated",HttpStatus.RESET_CONTENT);

        return responseEntity;
    }
}
