package com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.businesslayer.TicketService;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketRequestModel;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketResponseModel>> getAll(){
        return ResponseEntity.ok().body(ticketService.getAllTickets());
    }

    @GetMapping(value = "{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponseModel> get(@PathVariable String ticketId){
        return ResponseEntity.ok().body(ticketService.getTicket(ticketId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponseModel> add(@RequestBody TicketRequestModel ticketRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.addTicket(ticketRequestModel));
    }

    @PutMapping(value = "{ticketId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponseModel> edit(@PathVariable String ticketId, @RequestBody TicketRequestModel ticketRequestModel){
        return ResponseEntity.ok().body(ticketService.editTicket(ticketId, ticketRequestModel));
    }

    @DeleteMapping(value = "{ticketId}")
    public ResponseEntity<Void> delete(@PathVariable String ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
