package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/search")
	public String search(@RequestParam String query, Model model) {
		model.addAttribute("items", service.searchItems(query));
		return "index";
	}
}
