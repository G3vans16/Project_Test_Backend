package com.codeclan.example.project_test.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

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

    @Column(name = "nationality")
    private Country nationality;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "sign_up_list")
    private List<SignUp> signUpList;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    public User() {}

    public User(String displayName, String avatarUrl, String homeTown, Country nationality, int age, Location location) {
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.homeTown = homeTown;
        this.nationality = nationality;
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

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
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
