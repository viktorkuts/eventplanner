package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer, Integer> {
    Performer findPerformerByPerformerIdentifier_PerformerId(String performerId);
}
