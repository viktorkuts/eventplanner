package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.Ticket;
import com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer.TicketRepository;
import com.viktorkuts.eventplanner.ticketingsubdomain.mapperlayer.TicketResponseMapper;
import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.User;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.UserRepository;
import com.viktorkuts.eventplanner.usersubdomain.mapperlayer.UserResponseMapper;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserResponseModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserTicketsResponseModel;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketsServiceImpl implements UserTicketsService {
    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    private UserResponseMapper userResponseMapper;
    private TicketResponseMapper ticketResponseMapper;

    public UserTicketsServiceImpl(UserRepository userRepository, TicketRepository ticketRepository, UserResponseMapper userResponseMapper, TicketResponseMapper ticketResponseMapper) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.userResponseMapper = userResponseMapper;
        this.ticketResponseMapper = ticketResponseMapper;
    }

    @Override
    public UserTicketsResponseModel getAllTicketsByUserId(String userId){
        User foundUser = userRepository.findByUserIdentifier_UserId(userId);
        if(foundUser == null){
            throw new InvalidInputException("Unknown userId: " + userId);
        }
        List<Ticket> ticketList = ticketRepository.findTicketsByUser_UserIdentifier_UserId(userId);
        List<TicketResponseModel> tickets = ticketResponseMapper.entitiesToResponseModelList(ticketList);
        UserTicketsResponseModel userModel = userResponseMapper.entityToAggregateResponseModel(foundUser);
        userModel.setTickets(tickets);
        return userModel;
    }

}
