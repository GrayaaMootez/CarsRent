package com.cars.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Brand;
import com.cars.service.BrandService;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String allBrands(ModelMap model) {
		model.addAttribute("brands", brandService.findAll());
		return "/admin/brands";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addBrand(ModelMap map) {
		Brand brand = new Brand();
		map.addAttribute("brand", brand);
		return "/admin/addBrand";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("brand") Brand brand, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "/admin/addBrand";
		} else {

			Brand b = brandService.findById(brand.getBrandId());

			if (!b.equals(null)) {
				model.addAttribute("message", "true");
				return "/admin/addBrand";
			}

			brandService.ajout(brand);
			return "redirect:/admin/brand";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVhs(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		brandService.suppById(Double.parseDouble(id));
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/admin/brand";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editVh(@PathVariable("id") Double id, ModelMap model) {

		model.addAttribute("brand", brandService.findById(id));
		return "/admin/editBrands";
	}

}
