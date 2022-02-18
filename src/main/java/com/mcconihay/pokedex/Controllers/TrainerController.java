package com.mcconihay.pokedex.Controllers;

import com.mcconihay.pokedex.Models.Trainer;
import com.mcconihay.pokedex.Repository.TrainerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class TrainerController {
	private final TrainerRepo trainerDao;
	private final PasswordEncoder passwordEncoder;

	public TrainerController(TrainerRepo trainerDao, PasswordEncoder passwordEncoder) {
		this.trainerDao = trainerDao;

		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public String registerTrainer(@ModelAttribute Trainer trainer) {
		String hash = passwordEncoder.encode(trainer.getPassword());
		trainer.setPassword(hash);
		trainerDao.save(trainer);
		return "redirect:/";
	}
























}
