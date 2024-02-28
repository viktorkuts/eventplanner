package com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserIdentifier_UserId(String userId);
}
