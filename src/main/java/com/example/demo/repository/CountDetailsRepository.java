package com.example.demo.repository;

import com.example.demo.entity.CountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountDetailsRepository extends JpaRepository<CountDetails, Integer> {

    CountDetails findByLogin(String login);

}
