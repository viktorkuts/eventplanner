package com.viktorkuts.eventplanner.ticketingsubdomain.mapperlayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.Ticket;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.TicketController;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface TicketResponseMapper {
    @Mapping(expression = "java(ticket.getTicketIdentifier().getTicketId())", target = "ticketId")
    TicketResponseModel entityToResponseModel(Ticket ticket);
    List<TicketResponseModel> entitiesToResponseModelList(List<Ticket> tickets);

    @AfterMapping
    default void addLinks(@MappingTarget TicketResponseModel ticketResponseModel, Ticket ticket){
        Link selfLink = linkTo(methodOn(TicketController.class).get(ticketResponseModel.getTicketId())).withSelfRel();
        Link allLink = linkTo(methodOn(TicketController.class).getAll()).withRel("tickets");
        ticketResponseModel.add(selfLink, allLink);
    }
}
