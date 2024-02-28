package com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models;

import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.VenueAddress;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VenueRequestModel {
    private VenueAddress location;
    private String venueName;
}
