package com.viktorkuts.eventplanner.eventmanagementsubdomain.mapperlayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.Event;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.EventController;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {
    @Mapping(expression = "java(event.getEventIdentifier().getEventId())",target = "eventId")
    EventResponseModel entityToResponseModel(Event event);
    List<EventResponseModel> entityListToResponseModelList(List<Event> eventList);

    @AfterMapping
    default void addLinks(@MappingTarget EventResponseModel eventResponseModel, Event event){
        Link selfLink = linkTo(methodOn(EventController.class).get(eventResponseModel.getEventId())).withSelfRel();
        eventResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(EventController.class).getAll()).withRel("events");
        eventResponseModel.add(allLink);
    }
}
