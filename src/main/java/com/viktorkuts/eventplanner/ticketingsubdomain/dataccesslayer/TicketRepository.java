package com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketByTicketIdentifier_TicketId(String ticketId);
    List<Ticket> findTicketsByUser_UserIdentifier_UserId(String userId);
}
