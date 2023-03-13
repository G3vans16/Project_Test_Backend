package com.codeclan.example.project_test.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private List<User> userList;

    public Location() {}

    public Location(String name, Country country) {
        this.name = name;
        this.country = country;
        this.eventList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
