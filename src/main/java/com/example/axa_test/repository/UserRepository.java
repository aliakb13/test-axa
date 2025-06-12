package com.example.axa_test.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.axa_test.model.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}