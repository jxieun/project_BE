package com.baseballweb.auth.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 구장 ID

    private String name;  // 구장 이름
    private String location;  // 구장 위치

    @OneToMany(mappedBy = "stadium")
    private List<Review> reviews;  // 구장에 대한 리뷰 리스트

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
