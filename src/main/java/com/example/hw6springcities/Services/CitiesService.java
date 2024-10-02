package com.example.hw6springcities.Services;

import com.example.hw6springcities.Models.City;
import com.example.hw6springcities.Repo.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitiesService {
    private final ICityRepository cityRepository;

    @Autowired
    public CitiesService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> findById(long id) {
        return cityRepository.findById(id);
    }

    public Iterable<City> findAllByParameters(String cityName, String shortHistory, String numberOfInhabitants) {
        return cityRepository.findAll().stream()
                .filter(city -> city.getCityName().contains(cityName))
                .filter(city -> city.getShortHistory().contains(shortHistory))
                .filter(city -> Long.parseLong(city.getNumberOfInhabitants()) >= Long.parseLong(numberOfInhabitants))
                .toList();
    }

    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return cityRepository.existsById(id);
    }
}
