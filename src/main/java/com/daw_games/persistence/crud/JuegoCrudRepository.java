package com.daw_games.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw_games.persistence.entities.Juego;

public interface JuegoCrudRepository extends CrudRepository<Juego, Integer>{
	
	List<Juego> findByPrecioBetween(double min, double max);

}
