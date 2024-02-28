package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class UserIdentifier {
    @Column(name = "userid")
    private String userId;

    public UserIdentifier(){
        this.userId = UUID.randomUUID().toString();
    }

    public UserIdentifier(String userId){
        this.userId = userId;
    }
}
