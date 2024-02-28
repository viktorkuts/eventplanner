package com.viktorkuts.eventplanner.usersubdomain.mapperlayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerResponseModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.PerformerController;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface PerformerResponseMapper {
    @Mapping(expression = "java(performer.getPerformerIdentifier().getPerformerId())", target = "performerId")
    PerformerResponseModel entityToResponseModel(Performer performer);
    List<PerformerResponseModel> entityListToResponseModelList(List<Performer> performerList);

    @AfterMapping
    default void addLinks(@MappingTarget PerformerResponseModel responseModel, Performer performer){
        Link selfLink = linkTo(methodOn(PerformerController.class).get(responseModel.getPerformerId())).withSelfRel();
        responseModel.add(selfLink);

        Link allLink = linkTo(methodOn(PerformerController.class).getAll()).withRel("performers");
        responseModel.add(allLink);
    }
}
