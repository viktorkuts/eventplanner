package com.viktorkuts.eventplanner.usersubdomain.presentationlayer;

import com.viktorkuts.eventplanner.usersubdomain.businesslayer.PerformerService;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/performers")
public class PerformerController {
    private final PerformerService performerService;

    public PerformerController(PerformerService PerformerService) {
        this.performerService = PerformerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PerformerResponseModel>> getAll(){
        return ResponseEntity.ok().body(performerService.getAllPerformers());
    }

    @GetMapping(value = "{performerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformerResponseModel> get(@PathVariable String performerId){
        return ResponseEntity.ok().body(performerService.getPerformer(performerId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformerResponseModel> add(@RequestBody PerformerRequestModel PerformerRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(performerService.addPerformer(PerformerRequestModel));
    }

    @PutMapping(value = "{performerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformerResponseModel> edit(@PathVariable String performerId, @RequestBody PerformerRequestModel PerformerRequestModel){
        return ResponseEntity.ok().body(performerService.editPerformer(performerId, PerformerRequestModel));
    }

    @DeleteMapping(value = "{performerId}")
    public ResponseEntity<Void> delete(@PathVariable String performerId){
        performerService.deletePerformer(performerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
