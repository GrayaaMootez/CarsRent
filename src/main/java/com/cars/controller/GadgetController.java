package com.cars.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Gadget;
import com.cars.service.GadgetService;

@Component
@RequestMapping("/admin/gadget")
public class GadgetController {


	@Autowired
	private GadgetService service;


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String allGadgets(ModelMap model) {
		model.addAttribute("gadgets", service.findAll());
		return "/admin/gadgets";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGadget(ModelMap map) {
		Gadget gadget=new Gadget();
		map.addAttribute("gadget", gadget);
		return "/admin/addGadget";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("gadget") Gadget gadget, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "/admin/addGadget";
		} else {
		service.ajout(gadget);
			return "redirect:/admin/gadget";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVhs(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.suppById(Long.parseLong(id));
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/admin/gadget";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editVh(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("gadget", service.findById(id));
		return "/admin/editGadgets";
	}


}
