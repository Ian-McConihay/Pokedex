package com.mcconihay.pokedex.Repository;

import com.mcconihay.pokedex.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
	Trainer findByUsername(String username);
}
