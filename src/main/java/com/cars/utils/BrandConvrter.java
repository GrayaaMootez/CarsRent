package com.cars.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cars.dao.BrandDao;
import com.cars.model.Brand;

@Component
public class BrandConvrter extends PropertyEditorSupport {

	@Autowired
	private BrandDao service;

	// Converts a String to a Country (when submitting form)
	@Override
	public void setAsText(String text) {
		Brand c = service.findOne(Double.parseDouble(text));
		this.setValue(c);
	}

}
