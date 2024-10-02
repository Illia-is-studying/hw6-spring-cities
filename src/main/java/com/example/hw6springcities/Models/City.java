package com.example.hw6springcities.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cityName;
    private String numberOfInhabitants;
    private String shortHistory;
    private String cityCoordinates;
}
