package com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketRequestModel {
    private Date purchaseTime;
}
