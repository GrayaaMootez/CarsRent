package com.cars.utils;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cars.model.Booking;

public class DateValidator implements ConstraintValidator<ValidDates, Booking> {

	@Override
	public void initialize(ValidDates constraintAnnotation) {

	}

	@Override
	public boolean isValid(Booking values, ConstraintValidatorContext context) {

		Date startdate = values.getBookingFromDate();
		Date enddate = values.getBookingToDate();
		System.out.println("messssssage"+context.getDefaultConstraintMessageTemplate());

		return startdate.before(enddate);

	}

}
