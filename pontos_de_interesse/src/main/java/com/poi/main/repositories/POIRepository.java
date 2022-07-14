package com.poi.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poi.main.entities.POI;

@Repository
public interface POIRepository extends JpaRepository<POI, Integer> {
}
