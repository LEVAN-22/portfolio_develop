package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private PortfolioItemService service;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("items", service.getAllItems());
		return "index";
	}

	@GetMapping("/create")
	public String createForm(Model model) {
		model.addAttribute("portfolioItem", new PortfolioItem());
		return "create";
	}

	@PostMapping("/create")
	public String createSubmit(@ModelAttribute PortfolioItem portfolioItem) {
		service.createItem(portfolioItem);
		return "redirect:/complete";
	}

	@GetMapping("/complete")
	public String complete() {
		return "complete";
	}

	@GetMapping("/delete/{id}")
	public String deleteConfirm(@PathVariable Long id, Model model) {
		model.addAttribute("item", service.getItemById(id).orElse(null));
		return "delete-confirm";
	}

	@PostMapping("/delete/{id}")
	public String deleteSubmit(@PathVariable Long id) {
		service.deleteItem(id);
		return "redirect:/delete-complete";
	}

	@GetMapping("/delete-complete")
	public String deleteComplete() {
		return "delete-complete";
	}

	@GetMapping("/search")
	public String search(@RequestParam String query, Model model) {
		model.addAttribute("items", service.searchItems(query));
		return "index";
	}
}
