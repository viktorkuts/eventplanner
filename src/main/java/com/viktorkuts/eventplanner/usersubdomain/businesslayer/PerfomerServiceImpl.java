package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.PerformerIdentifier;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.PerformerRepository;
import com.viktorkuts.eventplanner.usersubdomain.mapperlayer.PerformerRequestMapper;
import com.viktorkuts.eventplanner.usersubdomain.mapperlayer.PerformerResponseMapper;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.PerformerResponseModel;
import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfomerServiceImpl implements PerformerService{
    private PerformerRepository performerRepository;
    private PerformerResponseMapper performerResponseMapper;
    private PerformerRequestMapper performerRequestMapper;

    public PerfomerServiceImpl(PerformerRepository performerRepository, PerformerResponseMapper performerResponseMapper, PerformerRequestMapper performerRequestMapper) {
        this.performerRepository = performerRepository;
        this.performerResponseMapper = performerResponseMapper;
        this.performerRequestMapper = performerRequestMapper;
    }

    @Override
    public List<PerformerResponseModel> getAllPerformers(){
        return performerResponseMapper.entityListToResponseModelList(performerRepository.findAll());
    }

    @Override
    public PerformerResponseModel getPerformer(String performerId){
        Performer foundPerformer = performerRepository.findPerformerByPerformerIdentifier_PerformerId(performerId);
        if(foundPerformer == null){
            throw new InvalidInputException("Unknown performerId: " + performerId);
        }
        return performerResponseMapper.entityToResponseModel(foundPerformer);
    }

    @Override
    public PerformerResponseModel addPerformer(PerformerRequestModel performerRequestModel){
        Performer newPerformer = performerRequestMapper.requestModelToEntity(performerRequestModel, new PerformerIdentifier());
        return performerResponseMapper.entityToResponseModel(newPerformer);
    }

    @Override
    public PerformerResponseModel editPerformer(String performerId, PerformerRequestModel performerRequestModel){
        Performer foundPerformer = performerRepository.findPerformerByPerformerIdentifier_PerformerId(performerId);
        if(foundPerformer == null){
            throw new InvalidInputException("Unknown performerId:" + performerId);
        }
        Performer updatedPerformer = performerRequestMapper.requestModelToEntity(performerRequestModel, foundPerformer.getPerformerIdentifier());
        performerRepository.save(updatedPerformer);
        return performerResponseMapper.entityToResponseModel(updatedPerformer);
    }

    @Override
    public void deletePerformer(String performerId){
        Performer performer = performerRepository.findPerformerByPerformerIdentifier_PerformerId(performerId);
        if(performer == null){
            throw new InvalidInputException("Unknown performerId:" + performerId);
        }
        try{
            performerRepository.delete(performer);
        }catch (DataIntegrityViolationException ex){
            throw new InUseException("Performer is in use, cannot delete!");
        }
    }
}
