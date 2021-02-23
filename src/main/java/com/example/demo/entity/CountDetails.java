package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "count_details")
public class CountDetails {

    @Id
    @Column(name = "login")
    private String login;
    @GeneratedValue
    private Integer request_count;

    public CountDetails(String login) {
        this.request_count = 1;
        this.login = login;
    }
}
