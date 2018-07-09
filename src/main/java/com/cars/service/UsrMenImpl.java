package com.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.Repository.UserMenRepository;
import com.cars.model.UsrMen;

@Service
public class UsrMenImpl implements UserMenService {

	@Autowired
	UserMenRepository repository;

	@Override
	public UsrMen getUser(String user) {
		return repository.findUser(user);
	}

}
