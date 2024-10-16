package com.daw_games.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw_games.persistence.entities.Juego;
import com.daw_games.persistence.entities.enumerados.Tipo;

public interface JuegoCrudRepository extends CrudRepository<Juego, Integer>{
	
	List<Juego> findByPrecioBetween(double min, double max);
	List<Juego> findByNombreEquals(String nombre);
	List<Juego> findByGeneroEquals(String genero);
	List<Juego> findByPlataformaEquals(String palataforma);
	List<Juego> findByTipo(Tipo tipo);
	List<Juego> findByDescargasGreaterThan(Integer descargas);

}
