package com.viktorkuts.eventplanner.ticketingsubdomain.dataccesslayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.User;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.UserIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "tickets")
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private TicketIdentifier ticketIdentifier;

    @Column(name = "purchasetime")
    private Date purchaseTime;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;
}
