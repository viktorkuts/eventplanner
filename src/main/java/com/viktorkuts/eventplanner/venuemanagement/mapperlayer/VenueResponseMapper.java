package com.viktorkuts.eventplanner.venuemanagement.mapperlayer;

import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.Venue;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.VenueController;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenueResponseMapper {
    @Mapping(expression = "java(venue.getVenueIdentifier().getVenueId())", target = "venueId")
    VenueResponseModel entityToResponseModel(Venue venue);
    List<VenueResponseModel> entitiesToResponseModelList(List<Venue> venueList);

    @AfterMapping
    default void addLinks(@MappingTarget VenueResponseModel venueResponseModel, Venue venue){
        Link selfLink = linkTo(methodOn(VenueController.class).get(venueResponseModel.getVenueId())).withSelfRel();
        Link allLink = linkTo(methodOn(VenueController.class).getAll()).withRel("venues");
        venueResponseModel.add(selfLink, allLink);
    }
}
