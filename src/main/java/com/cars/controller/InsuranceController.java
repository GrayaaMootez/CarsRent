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

import com.cars.model.Insurance;
import com.cars.service.InsuranceService;

@Component
@RequestMapping("/admin/insr")
public class InsuranceController {

	@Autowired
	private InsuranceService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String allIns(ModelMap model) {
		model.addAttribute("insrs", service.findAll());
		return "/admin/insrs";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addInsr(ModelMap map) {
		Insurance insr = new Insurance();
		map.addAttribute("insr", insr);
		return "/admin/addInsr";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("insr") Insurance insr, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "/admin/addInsr";
		} else {

			Insurance i = service.findById(insr.getInsuranceId());
			if (!i.equals(null)) {
				model.addAttribute("message", "true");
				return "/admin/addInsr";
			}

			service.ajout(insr);
			return "redirect:/admin/insr";
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("insr") Insurance insr, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "/admin/addInsr";
		} else {

			service.ajout(insr);
			return "redirect:/admin/insr";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVhs(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.suppById(Long.parseLong(id));
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/admin/insr";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editVh(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("insr", service.findById(id));
		return "/admin/editInsr";
	}

}
