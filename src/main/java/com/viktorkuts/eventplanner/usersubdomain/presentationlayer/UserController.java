package com.viktorkuts.eventplanner.usersubdomain.presentationlayer;

import com.viktorkuts.eventplanner.usersubdomain.businesslayer.UserService;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserRequestModel;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseModel>> getAll(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> get(@PathVariable String userId){
        return ResponseEntity.ok().body(userService.getUser(userId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> add(@RequestBody UserRequestModel userRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequestModel));
    }

    @PutMapping(value = "{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> edit(@PathVariable String userId, @RequestBody UserRequestModel userRequestModel){
        return ResponseEntity.ok().body(userService.editUser(userId, userRequestModel));
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}