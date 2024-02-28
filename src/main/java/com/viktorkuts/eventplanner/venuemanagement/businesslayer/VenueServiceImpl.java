package com.viktorkuts.eventplanner.venuemanagement.businesslayer;

import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.Venue;
import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.VenueIdentifier;
import com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer.VenueRepository;
import com.viktorkuts.eventplanner.venuemanagement.mapperlayer.VenueRequestMapper;
import com.viktorkuts.eventplanner.venuemanagement.mapperlayer.VenueResponseMapper;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueRequestModel;
import com.viktorkuts.eventplanner.venuemanagement.presentationlayer.models.VenueResponseModel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService{
    private VenueRepository venueRepository;
    private VenueRequestMapper venueRequestMapper;
    private VenueResponseMapper venueResponseMapper;

    public VenueServiceImpl(VenueRepository venueRepository, VenueRequestMapper venueRequestMapper, VenueResponseMapper venueResponseMapper) {
        this.venueRepository = venueRepository;
        this.venueRequestMapper = venueRequestMapper;
        this.venueResponseMapper = venueResponseMapper;
    }

    @Override
    public List<VenueResponseModel> getAllVenues(){
        return venueResponseMapper.entitiesToResponseModelList(venueRepository.findAll());
    }

    @Override
    public VenueResponseModel getVenue(String venueId){
        Venue foundVenue = venueRepository.findVenueByVenueIdentifier_VenueId(venueId);
        if(foundVenue == null){
            throw new InvalidInputException("Unknown venueId: " + venueId);
        }
        return venueResponseMapper.entityToResponseModel(foundVenue);
    }

    @Override
    public VenueResponseModel addVenue(VenueRequestModel venueRequestModel){
        Venue newVenue = venueRequestMapper.requestModelToEntity(venueRequestModel, new VenueIdentifier());
        venueRepository.save(newVenue);
        return venueResponseMapper.entityToResponseModel(newVenue);
    }

    @Override
    public VenueResponseModel editVenue(String venueId, VenueRequestModel venueRequestModel){
        Venue foundVenue = venueRepository.findVenueByVenueIdentifier_VenueId(venueId);
        if(foundVenue == null){
            throw new InvalidInputException("Unknown venueId: " + venueId);
        }
        Venue updatedVenue = venueRequestMapper.requestModelToEntity(venueRequestModel, foundVenue.getVenueIdentifier());
        venueRepository.save(updatedVenue);
        return venueResponseMapper.entityToResponseModel(updatedVenue);
    }

    @Override
    public void deleteVenue(String venueId){
        Venue foundVenue = venueRepository.findVenueByVenueIdentifier_VenueId(venueId);
        if(foundVenue == null){
            throw new InvalidInputException("Unknown venueId: " + venueId);
        }
        try{
            venueRepository.delete(foundVenue);
        }catch (DataIntegrityViolationException ex){
            throw new InUseException("Venue is in use by dependency, cannot delete!");
        }
    }
}
