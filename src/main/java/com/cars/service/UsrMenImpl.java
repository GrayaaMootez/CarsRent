package com.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.UserMenDao;
import com.cars.model.UsrMen;

@Service
public class UsrMenImpl implements UserMenService {

	@Autowired
	UserMenDao dao;

	@Override
	public UsrMen getUser(String user) {
		return dao.findUser(user);
	}

}
