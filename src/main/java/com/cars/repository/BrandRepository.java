package com.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Double>{




}
