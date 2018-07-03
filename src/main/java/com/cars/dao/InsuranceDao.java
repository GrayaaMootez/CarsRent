package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Insurance;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Long>{

}
