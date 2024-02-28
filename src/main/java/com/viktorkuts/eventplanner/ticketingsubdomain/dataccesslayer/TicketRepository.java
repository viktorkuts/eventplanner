package com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketByTicketIdentifier_TicketId(String ticketId);
}
