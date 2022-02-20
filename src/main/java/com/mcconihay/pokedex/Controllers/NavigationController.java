package com.mcconihay.pokedex.Controllers;

import com.mcconihay.pokedex.Models.Trainer;
import com.mcconihay.pokedex.Repository.TrainerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	private final TrainerRepo trainerDao;

	public NavigationController(TrainerRepo trainerDao) {
		this.trainerDao = trainerDao;
	}

	@GetMapping("/")
	public String viewLandingPage(Model model) {
		model.addAttribute("trainer", new Trainer());
		return "templates/views/landing-page";
	}

	@GetMapping("/test")
	public String viewTest(){
		return "templates/views/test";
	}




}
