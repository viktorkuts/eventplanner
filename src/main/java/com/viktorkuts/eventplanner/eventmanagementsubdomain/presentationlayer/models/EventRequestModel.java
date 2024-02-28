package com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventType;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventRequestModel {
    private String eventName;
    private Date startsAt;
    private Date endsAt;
    private EventType eventType;
    private Performer performer;
}
