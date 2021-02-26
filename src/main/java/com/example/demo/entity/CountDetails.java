package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CountDetails {

    @Id
    private String login;

    @GeneratedValue
    private Integer request_count;

    public CountDetails(String login) {
        this.request_count = 1;
        this.login = login;
    }
}
