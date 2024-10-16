package com.daw_games.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw_games.persistence.entities.Juego;
import com.daw_games.persistence.entities.enumerados.Tipo;
import com.daw_games.service.dto.JuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegoController {
	
	@Autowired
	private JuegoService juegoService;

	@GetMapping
	public ResponseEntity<List<Juego>> list() {
		return ResponseEntity.ok(this.juegoService.getAll());
	}

	@GetMapping("/{idJuego}")
	public ResponseEntity<Juego> findOne(@PathVariable("idJuego") int idJuego) {
		Optional<Juego> juego = this.juegoService.getJuego(idJuego);

		if (juego.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(this.juegoService.getJuego(idJuego).get());
		}
	}

	@PostMapping
	public ResponseEntity<Juego> create(@RequestBody Juego juego) {
		return new ResponseEntity<Juego>(this.juegoService.create(juego), HttpStatus.CREATED);
	}

	@PutMapping("/{idJuego")
	public ResponseEntity<Juego> update(@PathVariable("idJuego") int idJuego, @RequestBody Juego juego) {
		if (idJuego != juego.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (this.juegoService.getJuego(idJuego).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.juegoService.save(juego));
	}

	@DeleteMapping("/{idJuego}")
	public ResponseEntity<Juego> delete(@PathVariable("idJuego") int idJuego) {

		if (this.juegoService.delete(idJuego)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/precio")
	public ResponseEntity<List<Juego>> buscarPorPrecio(@RequestParam("min") double min,
			@RequestParam("max") double max) {
		return ResponseEntity.ok(this.juegoService.getByPrecio(min, max));
	}
	
	@GetMapping("/nombre")
	public ResponseEntity<List<Juego>> buscarPorNombre(@RequestParam("nombre") String nombre) {
		return ResponseEntity.ok(this.juegoService.getByNombre(nombre));
	}
	
	@GetMapping("/genero")
	public ResponseEntity<List<Juego>> buscarPorGenero(@RequestParam("genero") String genero) {
		return ResponseEntity.ok(this.juegoService.getByGenero(genero));
	}
	
	@GetMapping("/plataforma")
	public ResponseEntity<List<Juego>> buscarPorPlataforma(@RequestParam("plataforma") String plataforma) {
		return ResponseEntity.ok(this.juegoService.getByPlataforma(plataforma));
	}
	
	@GetMapping("/tipo")
	public ResponseEntity<List<Juego>> buscarPorTipo(@RequestParam("tipo") Tipo tipo) {
		return ResponseEntity.ok(this.juegoService.getByTipo(tipo));
	}
	
	@GetMapping("/descargas")
	public ResponseEntity<List<Juego>> buscarPorDescargas(@RequestParam("descargas") Integer descargas) {
		return ResponseEntity.ok(this.juegoService.getByDescargas(descargas));
	}
	
	@PutMapping("/completar")
	public ResponseEntity<Juego> completar(@RequestParam("completar") Juego juego) {
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/desmarcar")
	public ResponseEntity<Juego> desmarcar(@RequestParam("desmarcar") Juego juego) {
		return ResponseEntity.ok().build();
	}
}
