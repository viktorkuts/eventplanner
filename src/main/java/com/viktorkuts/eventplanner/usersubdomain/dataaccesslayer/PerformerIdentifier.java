package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class PerformerIdentifier {
    @Column(name = "performerid")
    private String performerId;

    public PerformerIdentifier(){
        this.performerId = UUID.randomUUID().toString();
    }
    public PerformerIdentifier(String performerId) {
        this.performerId = performerId;
    }
}
