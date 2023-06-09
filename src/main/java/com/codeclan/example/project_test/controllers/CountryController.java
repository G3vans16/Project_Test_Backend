package com.codeclan.example.project_test.controllers;

import com.codeclan.example.project_test.models.Country;
import com.codeclan.example.project_test.models.Event;
import com.codeclan.example.project_test.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<Country>> getAllCountries(){
        return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
    }
}
