package com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models;

import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.VenueAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VenueResponseModel extends RepresentationModel<VenueResponseModel> {
    private String venueName;
    private VenueAddress location;
    private String venueId;
}
