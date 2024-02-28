package com.viktorkuts.eventplanner.ticketingsubdomain.presentationlayer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TicketResponseModel extends RepresentationModel<TicketResponseModel> {
    private String ticketId;
    private Date purchaseTime;
}
