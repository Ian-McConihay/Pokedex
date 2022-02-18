package com.mcconihay.pokedex.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false, length = 240, unique = true)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, precision = 3, scale = 0)
	private int age;

	public Trainer(Trainer trainer) {
	}

//	@OneToMany(mappedBy = "trainer")
//	private List<Pokemon> trainerPokemon;

//	@OneToMany(mappedBy = "trainer")
//	private List<Pokemon> trainerFavorites;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Column(nullable = false, length = 10)
	private String dateJoined;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}