package com.example.hw6springcities.Controllers;

import com.example.hw6springcities.Models.City;
import com.example.hw6springcities.Services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class CitiesController {
    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/cities")
    public String citiesIndex(
            @RequestParam(name = "cityName", required = false, defaultValue = "")
            String cityName,
            @RequestParam(name = "numberOfInhabitants", required = false, defaultValue = "0")
            String numberOfInhabitants,
            @RequestParam(name = "shortHistory", required = false, defaultValue = "")
            String shortHistory,
                              Model model) {
        Iterable<City> cities = citiesService.findAllByParameters(cityName, shortHistory, numberOfInhabitants);
        ArrayList<City> citiesList = new ArrayList<>();

        cities.forEach(citiesList::add);
        Collections.reverse(citiesList);

        model.addAttribute("cities", citiesList);

        return "cities";
    }

    @GetMapping("/addCity")
    public String addCity() {
        return "addCity";
    }

    @PostMapping("/addCity")
    public String addCity(@ModelAttribute("city") City city) {
        citiesService.save(city);

        return "redirect:/cities";
    }

    @GetMapping("/cities/{id}")
    public String cityDetails(@PathVariable(value = "id") long id, Model model) {
        if (!citiesService.existsById(id)) {
            return "redirect:/cities";
        }

        model.addAttribute("city", citiesService.findById(id).get());
        return "cityDetails";
    }

    @GetMapping("/cities/{id}/edit")
    public String editCity(@PathVariable(value = "id") long id, Model model) {
        if (!citiesService.existsById(id)) {
            return "redirect:/cities";
        }

        model.addAttribute("city", citiesService.findById(id).get());
        return "editCity";
    }

    @PostMapping("/cities/{id}/edit")
    public String editCity(@ModelAttribute("city") City city, @PathVariable(value = "id") long id) {
        if (citiesService.existsById(id)) {
            citiesService.save(city);
        }

        return "redirect:/cities";
    }

    @GetMapping("/cities/{id}/delete")
    public String deleteCity(@PathVariable(value = "id") long id) {
        if (citiesService.existsById(id)) {
            citiesService.deleteById(id);
        }

        return "redirect:/cities";
    }
}
