package com.viktorkuts.eventplanner.ticketingsubdomain.businesslayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.Ticket;
import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.TicketIdentifier;
import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.TicketRepository;
import com.viktorkuts.eventplanner.ticketingsubdomain.mapperlayer.TicketRequestMapper;
import com.viktorkuts.eventplanner.ticketingsubdomain.mapperlayer.TicketResponseMapper;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketRequestModel;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;
import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private TicketResponseMapper ticketResponseMapper;
    private TicketRequestMapper ticketRequestMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketResponseMapper ticketResponseMapper, TicketRequestMapper ticketRequestMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketResponseMapper = ticketResponseMapper;
        this.ticketRequestMapper = ticketRequestMapper;
    }

    @Override
    public List<TicketResponseModel> getAllTickets(){
        return ticketResponseMapper.entitiesToResponseModelList(ticketRepository.findAll());
    }

    @Override
    public TicketResponseModel getTicket(String ticketId){
        Ticket foundTicket = ticketRepository.findTicketByTicketIdentifier_TicketId(ticketId);
        if(foundTicket == null){
            throw new InvalidInputException("Unknown ticketId: " + ticketId);
        }
        return ticketResponseMapper.entityToResponseModel(foundTicket);
    }

    @Override
    public TicketResponseModel addTicket(TicketRequestModel ticketRequestModel){
        Ticket newTicket = ticketRequestMapper.requestModelToEntity(ticketRequestModel, new TicketIdentifier());
        ticketRepository.save(newTicket);
        return ticketResponseMapper.entityToResponseModel(newTicket);
    }

    @Override
    public TicketResponseModel editTicket(String ticketId, TicketRequestModel ticketRequestModel){
        Ticket foundTicket = ticketRepository.findTicketByTicketIdentifier_TicketId(ticketId);
        if(foundTicket == null){
            throw new InvalidInputException("Unknown ticketId: " + ticketId);
        }
        Ticket updatedTicket = ticketRequestMapper.requestModelToEntity(ticketRequestModel, foundTicket.getTicketIdentifier());
        return ticketResponseMapper.entityToResponseModel(updatedTicket);
    }

    @Override
    public void deleteTicket(String ticketId){
        Ticket foundTicket = ticketRepository.findTicketByTicketIdentifier_TicketId(ticketId);
        if(foundTicket == null){
            throw new InvalidInputException("Unknown ticketId: " + ticketId);
        }
        try{
            ticketRepository.delete(foundTicket);
        }catch (DataIntegrityViolationException ex){
            throw new InUseException("Ticket is in use by dependency, cannot delete!");
        }
    }
}
