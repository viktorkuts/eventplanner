package com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserResponseModel extends RepresentationModel<UserResponseModel> {
    private String userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String phone;
}
