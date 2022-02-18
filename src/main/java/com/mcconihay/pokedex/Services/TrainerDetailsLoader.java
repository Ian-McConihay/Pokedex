package com.mcconihay.pokedex.Services;

import com.mcconihay.pokedex.Models.Trainer;
import com.mcconihay.pokedex.Models.TrainerWithRoles;
import com.mcconihay.pokedex.Repository.TrainerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrainerDetailsLoader implements UserDetailsService {
	private final TrainerRepo trainers;
	public TrainerDetailsLoader (TrainerRepo trainers) {
		this.trainers = trainers;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Trainer trainer = trainers.findByUsername(username);
		if (trainer == null) {
			throw new UsernameNotFoundException("No user found for " + username);
		}
		return new TrainerWithRoles(trainer);
	}
}
