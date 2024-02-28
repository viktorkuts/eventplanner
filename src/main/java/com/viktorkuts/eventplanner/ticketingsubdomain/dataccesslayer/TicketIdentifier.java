package com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class TicketIdentifier {
    @Column(name = "ticketid")
    private String ticketId;

    public TicketIdentifier(){
        this.ticketId = UUID.randomUUID().toString();
    }

    public TicketIdentifier(String ticketId) {
        this.ticketId = ticketId;
    }
}
