package com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequestModel {
    String firstName;
    String lastName;
    Date dob;
    String email;
    String phone;
}
