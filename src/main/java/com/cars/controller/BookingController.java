package com.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Booking;
import com.cars.service.BookingService;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String findAllBooking(Model model) {
		List<Booking> list = service.findAll();
		model.addAttribute("bookings", list);
		return "/booking/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteBooking(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.suppById(Long.parseLong(id));
		redirectAttributes.addFlashAttribute("msg", "deleted");
		return "/booking/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBooking(@PathVariable("id") Long id, Model model, final RedirectAttributes redirectAttributes)

	{
		model.addAttribute("booking", service.findById(id));
		redirectAttributes.addFlashAttribute("msg", "edited");

		return "/booking/edit";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBooking(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "/booking/add";
	}

}
