package com.codeclan.example.project_test.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @JsonIgnoreProperties({"country"})
    @OneToMany(mappedBy = "country")
    private List<UserProfile> userProfileList;

//    @JsonIgnoreProperties({"country"})
    @OneToMany(mappedBy = "country")
    private List<Location> locationList;

    public Country() {}

    public Country(String name) {
        this.name = name;
        this.userProfileList = new ArrayList<>();
        this.locationList = new ArrayList<>();
    }

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

    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }

    public void setUserProfileList(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}
