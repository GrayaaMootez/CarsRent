package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Custumer;

@Repository
public interface CustumerDao extends JpaRepository<Custumer, Long>{

}
