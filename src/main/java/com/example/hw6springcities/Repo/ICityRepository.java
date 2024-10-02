package com.example.hw6springcities.Repo;

import com.example.hw6springcities.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {}
