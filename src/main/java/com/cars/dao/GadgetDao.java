package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Gadget;

@Repository
public interface GadgetDao extends JpaRepository<Gadget, Long>{

}
