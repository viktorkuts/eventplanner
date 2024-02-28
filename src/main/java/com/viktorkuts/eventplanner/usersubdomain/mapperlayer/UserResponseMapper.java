package com.viktorkuts.eventplanner.usersubdomain.mapperlayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.User;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserResponseModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserTicketsResponseModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.UserController;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.UserTicketsController;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    @Mapping(expression="java(user.getUserIdentifier().getUserId())", target = "userId")
    UserResponseModel entityToResponseModel(User user);
    List<UserResponseModel> entityListToResponseModelList(List<User> users);
    UserTicketsResponseModel entityToAggregateResponseModel(User user);
    @AfterMapping
    default void addLinks(@MappingTarget UserResponseModel model, User user){
        Link selfLink = linkTo(methodOn(UserController.class).get(model.getUserId())).withSelfRel();
        model.add(selfLink);

        Link allLink = linkTo(methodOn(UserController.class).getAll()).withRel("users");
        model.add(allLink);

        Link ticketLink = linkTo(methodOn(UserTicketsController.class).get(model.getUserId())).withRel("tickets");
        model.add(ticketLink);
    }
}
