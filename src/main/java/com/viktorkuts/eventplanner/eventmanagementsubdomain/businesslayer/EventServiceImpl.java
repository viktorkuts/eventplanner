package com.viktorkuts.eventplanner.eventmanagementsubdomain.businesslayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.Event;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventIdentifier;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventRepository;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.mapperlayer.EventRequestMapper;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.mapperlayer.EventResponseMapper;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventRequestModel;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventResponseModel;
import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private EventRequestMapper eventRequestMapper;
    private EventResponseMapper eventResponseMapper;

    public EventServiceImpl(EventRepository eventRepository, EventRequestMapper eventRequestMapper, EventResponseMapper eventResponseMapper) {
        this.eventRepository = eventRepository;
        this.eventRequestMapper = eventRequestMapper;
        this.eventResponseMapper = eventResponseMapper;
    }

    @Override
    public List<EventResponseModel> getAllEvents(){
        return eventResponseMapper.entityListToResponseModelList(eventRepository.findAll());
    }

    @Override
    public EventResponseModel getEvent(String eventId){
        Event foundEvent = eventRepository.findEventByEventIdentifier_EventId(eventId);
        if(foundEvent == null){
            throw new InvalidInputException("Invalid eventId: " + eventId);
        }
        return eventResponseMapper.entityToResponseModel(foundEvent);
    }

    @Override
    public EventResponseModel addEvent(EventRequestModel eventRequestModel){
        Event newEvent = eventRequestMapper.requestModelToEntity(eventRequestModel, new EventIdentifier());
        return eventResponseMapper.entityToResponseModel(newEvent);
    }

    @Override
    public EventResponseModel editEvent(String eventId, EventRequestModel eventRequestModel){
        Event foundEvent = eventRepository.findEventByEventIdentifier_EventId(eventId);
        if(foundEvent == null){
            throw new InvalidInputException("Invalid eventId: " + eventId);
        }
        Event newEvent = eventRequestMapper.requestModelToEntity(eventRequestModel, foundEvent.getEventIdentifier());
        eventRepository.save(newEvent);
        return eventResponseMapper.entityToResponseModel(newEvent);
    }

    @Override
    public void deleteEvent(String eventId){
        Event foundEvent = eventRepository.findEventByEventIdentifier_EventId(eventId);
        if(foundEvent == null){
            throw new InvalidInputException("Invalid eventId: " + eventId);
        }
        try{
            eventRepository.delete(foundEvent);
        }catch (DataIntegrityViolationException ex){
            throw new InUseException("Event is already used by another entity, cannot delete!");
        }
    }
}
