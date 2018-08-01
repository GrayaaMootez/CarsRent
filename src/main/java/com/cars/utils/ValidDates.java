package com.cars.utils;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface ValidDates {
	String message() default "{message.date.validation}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}