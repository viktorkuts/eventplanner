package com.viktorkuts.eventplanner.venuemanagement.presentationlayer;

import com.viktorkuts.eventplanner.venuemanagement.businesslayer.VenueService;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueRequestModel;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VenueResponseModel>> getAll(){
        return ResponseEntity.ok().body(venueService.getAllVenues());
    }

    @GetMapping(value = "{venueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VenueResponseModel> get(@PathVariable String venueId){
        return ResponseEntity.ok().body(venueService.getVenue(venueId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VenueResponseModel> add(@RequestBody VenueRequestModel venueRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(venueService.addVenue(venueRequestModel));
    }

    @PutMapping(value = "{venueId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VenueResponseModel> edit(@PathVariable String venueId, @RequestBody VenueRequestModel venueRequestModel){
        return ResponseEntity.ok().body(venueService.editVenue(venueId, venueRequestModel));
    }

    @DeleteMapping(value = "{venueId}")
    public ResponseEntity<Void> delete(@PathVariable String venueId){
        venueService.deleteVenue(venueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
