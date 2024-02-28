package com.viktorkuts.eventplanner.ticketingsubdomain.businesslayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketRequestModel;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;

import java.util.List;

public interface TicketService {
    List<TicketResponseModel> getAllTickets();
    TicketResponseModel getTicket(String ticketId);
    TicketResponseModel addTicket(TicketRequestModel ticketRequestModel);
    TicketResponseModel editTicket(String ticketId, TicketRequestModel ticketRequestModel);
    void deleteTicket(String ticketId);
}
