package com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.businesslayer.EventService;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventRequestModel;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventResponseModel>> getAll(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }
    @GetMapping(value = "{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponseModel> get(@PathVariable String eventId){
        return ResponseEntity.ok().body(eventService.getEvent(eventId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponseModel> add(@RequestBody EventRequestModel eventRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(eventRequestModel));
    }

    @PutMapping(value = "{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponseModel> edit(@PathVariable String eventId, @RequestBody EventRequestModel eventRequestModel){
        return ResponseEntity.ok().body(eventService.editEvent(eventId, eventRequestModel));
    }

    @DeleteMapping(value = "{eventId}")
    public ResponseEntity<Void> delete(@PathVariable String eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
