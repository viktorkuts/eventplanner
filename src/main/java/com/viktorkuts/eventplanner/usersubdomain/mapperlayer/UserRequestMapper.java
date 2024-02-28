package com.viktorkuts.eventplanner.usersubdomain.mapperlayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.User;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.UserIdentifier;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    @Mapping(target = "id", ignore = true)
    User requestModelToEntity(UserRequestModel userRequestModel, UserIdentifier userIdentifier);
}
