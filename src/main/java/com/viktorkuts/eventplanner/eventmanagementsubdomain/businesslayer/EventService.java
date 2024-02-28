package com.viktorkuts.eventplanner.eventmanagementsubdomain.businesslayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventRequestModel;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventResponseModel;

import java.util.List;

public interface EventService {
    List<EventResponseModel> getAllEvents();
    EventResponseModel getEvent(String eventId);
    EventResponseModel addEvent(EventRequestModel eventRequestModel);
    EventResponseModel editEvent(String eventId, EventRequestModel eventRequestModel);
    void deleteEvent(String eventId);
}
