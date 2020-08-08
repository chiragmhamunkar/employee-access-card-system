package com.example.accesscard.repository;

import com.example.accesscard.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByLocationId(int id);
    Optional<Location> findByLocationName(String name);
}
