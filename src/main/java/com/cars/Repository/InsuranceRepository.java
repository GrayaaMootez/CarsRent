package com.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{

}
