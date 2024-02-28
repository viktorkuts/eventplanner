package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private UserIdentifier userIdentifier;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull Date dob, @NotNull String email, @NotNull String phone) {
        this.userIdentifier = new UserIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }
}
