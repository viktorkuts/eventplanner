package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserTicketsResponseModel;

public interface UserTicketsService {
    UserTicketsResponseModel getAllTicketsByUserId(String userId);
}
