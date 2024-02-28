package com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class VenueIdentifier {
    @Column(name = "venueid")
    private String venueId;
    public VenueIdentifier(){
        this.venueId = UUID.randomUUID().toString();
    }
    public VenueIdentifier(String venueId) {
        this.venueId = venueId;
    }
}
