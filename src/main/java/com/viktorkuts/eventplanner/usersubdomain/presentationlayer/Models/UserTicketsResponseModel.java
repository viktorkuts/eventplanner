package com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models;

import com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models.TicketResponseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserTicketsResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String phone;
    private List<TicketResponseModel> tickets;
}
