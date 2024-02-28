package com.viktorkuts.eventplanner.usersubdomain.mapperlayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.PerformerIdentifier;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface PerformerRequestMapper {
    @Mapping(target = "id", ignore = true)
    Performer requestModelToEntity(PerformerRequestModel performerRequestModel, PerformerIdentifier performerIdentifier);
}
