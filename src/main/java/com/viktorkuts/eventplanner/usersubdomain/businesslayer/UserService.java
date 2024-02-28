package com.viktorkuts.eventplanner.usersubdomain.businesslayer;

import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getAllUsers();
    UserResponseModel getUser(String userId);
    UserResponseModel addUser(UserRequestModel userRequestModel);
    UserResponseModel editUser(String userId, UserRequestModel userRequestModel);
    void deleteUser(String userId);
}
