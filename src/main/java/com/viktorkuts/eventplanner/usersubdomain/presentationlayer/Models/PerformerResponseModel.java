package com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PerformerResponseModel extends RepresentationModel<PerformerResponseModel> {
    private String performerId;
    private String firstName;
    private String lastName;
    private String stageName;
    private Date dob;
    private String email;
    private String phone;
}
