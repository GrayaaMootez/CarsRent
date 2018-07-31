package com.cars.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/client/home")
public class ClientHomeController {


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String allGadgets(ModelMap model) {
		return "/client/home";
	}

}
