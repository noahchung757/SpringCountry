package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Country;
import dmacc.repository.CountryRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 2, 2021
 */

@Controller
public class WebController {
	@Autowired
	CountryRepository repo;
	
	@GetMapping({ "/", "viewAll" })
	public String viewAllCountries(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewCountry(model);
		}
		model.addAttribute("countries", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputCountry")
	public String addNewCountry(Model model) {
		Country c = new Country();
		model.addAttribute("newCountry", c);
		return "input";
	}
	
	@PostMapping("/inputCountry")
	public String addNewCountry(@ModelAttribute Country c, Model model) {
		repo.save(c);
		return viewAllCountries(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateCountry(@PathVariable("id") long id, Model model) {
		Country c = repo.findById(id).orElse(null);
		model.addAttribute("newCountry", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseCountry(Country c, Model model) {
		repo.save(c);
		return viewAllCountries(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Country c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllCountries(model);
	}
}
