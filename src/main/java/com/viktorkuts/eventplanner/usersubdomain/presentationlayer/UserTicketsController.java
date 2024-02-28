package com.viktorkuts.eventplanner.usersubdomain.presentationlayer;

import com.viktorkuts.eventplanner.usersubdomain.businesslayer.UserTicketsService;
import com.viktorkuts.eventplanner.usersubdomain.presentationlayer.Models.UserTicketsResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{userId}/tickets")
public class UserTicketsController {
    private UserTicketsService userTicketsService;

    public UserTicketsController(UserTicketsService userTicketsService) {
        this.userTicketsService = userTicketsService;
    }

    @GetMapping()
    public ResponseEntity<UserTicketsResponseModel> get(@PathVariable String userId){
        return ResponseEntity.ok().body(userTicketsService.getAllTicketsByUserId(userId));
    }
}
