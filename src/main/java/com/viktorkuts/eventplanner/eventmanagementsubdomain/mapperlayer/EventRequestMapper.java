package com.viktorkuts.eventplanner.eventmanagementsubdomain.mapperlayer;

import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.Event;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer.EventIdentifier;
import com.viktorkuts.eventplanner.eventmanagementsubdomain.presentationlayer.models.EventRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {
    @Mapping(target = "id", ignore = true)
    Event requestModelToEntity(EventRequestModel eventRequestModel, EventIdentifier eventIdentifier);
}
