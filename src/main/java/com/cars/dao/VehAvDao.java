package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.VehAv;

@Repository
public interface VehAvDao extends JpaRepository<VehAv, Long>{

}
