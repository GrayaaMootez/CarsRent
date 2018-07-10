package com.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.VehAv;

@Repository
public interface VehAvRepository extends JpaRepository<VehAv, Long>{

}
