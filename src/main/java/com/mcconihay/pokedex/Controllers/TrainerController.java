package com.mcconihay.pokedex.Controllers;

import com.mcconihay.pokedex.Models.Trainer;
import com.mcconihay.pokedex.Repository.TrainerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainerController {
	private final TrainerRepo trainerDao;

	public TrainerController(TrainerRepo trainerDao) {
		this.trainerDao = trainerDao;
	}

	@PostMapping("/register")
	public String registerTraineer(@ModelAttribute Trainer trainer) {
		String hash = passwordEncoder.encode(trainer.getPassword());
		trainer.setPassword(hash);


//        User userCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        user.setUser(userCreator);

		trainerDao.save(trainer);


		return "redirect:/";
	}
























}
