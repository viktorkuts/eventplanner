package com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.Event;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

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
//    private List<Event> eventList;
}
