package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerResponseModel;

import java.util.List;

public interface PerformerService {
    List<PerformerResponseModel> getAllPerformers();
    PerformerResponseModel getPerformer(String performerId);
    PerformerResponseModel addPerformer(PerformerRequestModel performerRequestModel);
    PerformerResponseModel editPerformer(String performerId, PerformerRequestModel performerRequestModel);
    void deletePerformer(String performerId);
}
