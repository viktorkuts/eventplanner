package com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class EventIdentifier {
    @Column(name = "eventid")
    private String eventId;

    public EventIdentifier(){
        this.eventId = UUID.randomUUID().toString();
    }
    public EventIdentifier(String eventId) {
        this.eventId = eventId;
    }
}
