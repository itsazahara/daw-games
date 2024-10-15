package com.daw_games.service.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw_games.persistence.crud.JuegoCrudRepository;
import com.daw_games.persistence.entities.Juego;

@Service
public class JuegoService {
	
	@Autowired
	private JuegoCrudRepository juegoCrudRepository;
	
	public List<Juego> getAll() {
		return (List<Juego>) this.juegoCrudRepository.findAll();
	}
	
	public Optional<Juego> getJuego(int idJuego){
		return this.juegoCrudRepository.findById(idJuego);
	}
	
	
	public Juego create(Juego juego) {
		juego.setCompletado(false);
		return this.juegoCrudRepository.save(juego);
	}
	
	public Juego save(Juego juego) {
		return this.juegoCrudRepository.save(juego);
	}

	public boolean delete (int idJuego) {
		boolean res = false;
		
		if (this.juegoCrudRepository.findById(idJuego).isPresent()) {
			this.juegoCrudRepository.deleteById(idJuego);
			res = true;
		}
		return res;
	}
	
	public List<Juego> getByPrecio  (double min, double max){
		return this.juegoCrudRepository.findByPrecioBetween(min, max);
	}
}
