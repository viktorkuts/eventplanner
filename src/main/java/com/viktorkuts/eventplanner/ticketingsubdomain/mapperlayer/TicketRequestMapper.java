package com.viktorkuts.eventplanner.ticketingsubdomain.mapperlayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.Ticket;
import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.TicketIdentifier;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketRequestMapper {
    @Mapping(target = "id", ignore = true)
    Ticket requestModelToEntity(TicketRequestModel ticketRequestModel, TicketIdentifier ticketIdentifier);
}
