package com.codeclan.example.project_test.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
//    @JsonIgnoreProperties({"locations"})
//    @JsonBackReference
    @JoinColumn(name = "country")
    private Country country;

//    @JsonIgnoreProperties({"location"})
    @OneToMany(mappedBy = "location")
    private List<Event> eventList;

//    @JsonIgnoreProperties({"location"})
    @OneToMany(mappedBy = "location")
    private List<UserProfile> userProfileList;

    public Location() {}

    public Location(String name, Country country) {
        this.name = name;
        this.country = country;
        this.eventList = new ArrayList<>();
        this.userProfileList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }

    public void setUserProfileList(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }
}
