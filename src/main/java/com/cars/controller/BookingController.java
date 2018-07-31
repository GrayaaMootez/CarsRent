package com.cars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Booking;
import com.cars.model.Gadget;
import com.cars.model.Insurance;
import com.cars.model.Vehicles;
import com.cars.service.BookingService;
import com.cars.service.GadgetService;
import com.cars.service.InsuranceService;
import com.cars.service.VehiculesService;

@RequestMapping("/client/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingService service;

	@Autowired
	private GadgetService gservice;

	@Autowired
	private VehiculesService vservice;

	@Autowired
	private InsuranceService iservice;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findAllBooking(Model model) {
		List<Booking> list = service.findAll();
		model.addAttribute("bookings", list);
		return "/client/bookings";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBooking(@PathVariable("id") Long id, Model model, final RedirectAttributes redirectAttributes)

	{
		model.addAttribute("booking", service.findById(id));
		redirectAttributes.addFlashAttribute("msg", "edited");

		return "/booking/edit";

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("booking") Booking booking, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "/client/addBooking";
		} else {
			service.ajout(booking);
			return "redirect:/client/booking";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBooking(Model model) {

		Booking booking = new Booking();
		model.addAttribute("booking", booking);

		return "/client/addBooking";
	}

	@ModelAttribute("gadgets")
	public List<Gadget> gadgets() {
		return gservice.findAll();
	}

	@ModelAttribute("ins")
	public List<Insurance> insur() {
		return iservice.findAll();
	}

	@ModelAttribute("vhs")
	public List<Vehicles> vhs() {

		List<Vehicles> vhs = new ArrayList<>();
		List<Long> ids = vservice.vehiculesAvaible();

		for (Long l : ids) {
			vhs.add(vservice.findById(l));
		}

		return vhs;
	}

}
