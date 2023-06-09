package com.codeclan.example.project_test.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profiles")
@JsonIgnoreProperties({"signUpList"})
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "home_town")
    private String homeTown;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "age")
    private int age;

//    @JsonBackReference
    @OneToMany(mappedBy = "userProfile")
    private List<SignUp> signUpList;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    public UserProfile() {}

    public UserProfile(String displayName, String avatarUrl, String homeTown, Country country, int age, Location location) {
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.homeTown = homeTown;
        this.country = country;
        this.age = age;
        this.signUpList = new ArrayList<>();
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SignUp> getSignUpList() {
        return signUpList;
    }

    public void setSignUpList(List<SignUp> signUpList) {
        this.signUpList = signUpList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
