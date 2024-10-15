package com.daw_games.persistence.entities;

import java.time.LocalDateTime;

import com.daw_games.persistence.entities.enumerados.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "juego")

public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String genero;
	private String compania;
	private String plataforma;
	private double precio;
	private Integer descargas;
	
	@Column(name = "fecha_lanzamiento")
	private LocalDateTime fechaLanzamiento;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private Boolean completado;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getDescargas() {
		return descargas;
	}
	public void setDescargas(Integer descargas) {
		this.descargas = descargas;
	}
	public LocalDateTime getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Boolean getCompletado() {
		return completado;
	}
	public void setCompletado(Boolean completado) {
		this.completado = completado;
	}

}
