package com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventType;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
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
public class EventResponseModel extends RepresentationModel<EventResponseModel> {
    private String eventId;
    private String eventName;
    private Date startsAt;
    private Date endsAt;
    private EventType eventType;
//    private Performer performer;
}
