package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.Event;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "performers")
@NoArgsConstructor
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PerformerIdentifier performerIdentifier;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "stagename")
    private String stageName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public Performer(@NotNull String firstName, @NotNull String lastName, @NotNull String stageName, @NotNull Date dob, @NotNull String email, @NotNull String phone) {
        this.performerIdentifier = new PerformerIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }
}
