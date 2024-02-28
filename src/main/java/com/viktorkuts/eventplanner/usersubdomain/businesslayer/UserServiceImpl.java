package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.User;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.UserIdentifier;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.UserRepository;
import com.viktorkuts.eventplanner.usersubdomain.mapperlayer.UserRequestMapper;
import com.viktorkuts.eventplanner.usersubdomain.mapperlayer.UserResponseMapper;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserResponseModel;
import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private UserResponseMapper userResponseMapper;
    private UserRequestMapper userRequestMapper;

    public UserServiceImpl(UserRepository userRepository, UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
    }

    @Override
    public List<UserResponseModel> getAllUsers(){
        return userResponseMapper.entityListToResponseModelList(userRepository.findAll());
    }

    @Override
    public UserResponseModel getUser(String userId){
        User foundUser = userRepository.findByUserIdentifier_UserId(userId);
        if(foundUser == null){
            throw new InvalidInputException("Unknown userId: " + userId);
        }
        return userResponseMapper.entityToResponseModel(foundUser);
    }

    @Override
    public UserResponseModel addUser(UserRequestModel userRequestModel){
        User newUser = userRequestMapper.requestModelToEntity(userRequestModel, new UserIdentifier());
        return userResponseMapper.entityToResponseModel(newUser);
    }

    @Override
    public UserResponseModel editUser(String userId, UserRequestModel userRequestModel){
        User foundUser = userRepository.findByUserIdentifier_UserId(userId);
        if(foundUser == null){
            throw new InvalidInputException("Unknown userId: " + userId);
        }
        User updatedUser = userRequestMapper.requestModelToEntity(userRequestModel, foundUser.getUserIdentifier());
        userRepository.save(updatedUser);
        return userResponseMapper.entityToResponseModel(updatedUser);
    }

    @Override
    public void deleteUser(String userId){
        User foundUser = userRepository.findByUserIdentifier_UserId(userId);
        if(foundUser == null){
            throw new InvalidInputException("Unknown userId: " + userId);
        }
        try{
            userRepository.delete(foundUser);
        }catch (DataIntegrityViolationException ex){
            throw new InUseException("User is in use by other entity, cannot delete!");
        }
    }
}
