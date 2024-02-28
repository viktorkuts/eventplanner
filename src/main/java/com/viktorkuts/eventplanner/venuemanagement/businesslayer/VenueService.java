package com.viktorkuts.eventplanner.venuemanagement.businesslayer;

import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueRequestModel;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueResponseModel;

import java.util.List;

public interface VenueService {
    List<VenueResponseModel> getAllVenues();
    VenueResponseModel getVenue(String venueId);
    VenueResponseModel addVenue(VenueRequestModel venueRequestModel);
    VenueResponseModel editVenue(String venueId, VenueRequestModel venueRequestModel);
    void deleteVenue(String venueId);
}
