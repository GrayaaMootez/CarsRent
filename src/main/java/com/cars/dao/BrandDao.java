package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Double>{




}
