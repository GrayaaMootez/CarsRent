package com.cars.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Brand;
import com.cars.model.Vehicles;
import com.cars.service.BrandService;
import com.cars.service.VehiculesService;

@Controller
@RequestMapping("/vhs")
public class VehiclesController {

	@Autowired
	private VehiculesService service;

	@Autowired
	private BrandService bService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listV(Model model) {

		List<Vehicles> list = service.findAll();

		model.addAttribute("listVhs", list);
		return "/admin/vhs";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		Vehicles vh=new Vehicles();
		model.addAttribute("vehicule", vh);

		return "/admin/addVhs";
	}


	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("vehicule") Vehicles vehicule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("eeeeeeeeeeerrrrrrrrrrrrrrrrrrr");
			return "/admin/addVhs";
		} else {
			service.ajout(vehicule);
			return "redirect:/vhs";
		}
	}



	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVhs(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.suppById(Long.parseLong(id));
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/vhs";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editVh(@PathVariable("id") Long id, Model model) {
		model.addAttribute("vehicule", service.findById(id));
		return "/admin/editVhs";
	}

	@ModelAttribute("brands")
	public List<Brand> regionList() {
		return bService.findAll();
	}





}
