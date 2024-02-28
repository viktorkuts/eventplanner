package com.viktorkuts.eventplanner.venuemanagement.mapperlayer;

import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.Venue;
import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.VenueIdentifier;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VenueRequestMapper {
    @Mapping(target = "id", ignore = true)
    Venue requestModelToEntity(VenueRequestModel venueRequestModel, VenueIdentifier venueIdentifier);
}
