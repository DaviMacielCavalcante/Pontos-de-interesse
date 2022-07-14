package com.poi.main.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.management.InvalidAttributeValueException;
import javax.validation.constraints.NotEmpty;

public class POI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	
	private String nome;
	
	@NotEmpty(message = "O campo deve ser preenchido")
	private Integer cx;
	
	@NotEmpty(message = "O campo deve ser preenchido")
	private Integer cy;
	
	public POI() {		
	}

	public POI(Integer id, String nome, Integer cx, Integer cy) throws InvalidAttributeValueException {
		this.id = id;
		this.nome = nome;
		if (cx >= 0) {
			this.cx = cx;
		}
		else {
			throw new InvalidAttributeValueException("O valor não pode ser negativo");
		}
		if (cy >= 0) {
			this.cy = cy;
		}
		else {
			throw new InvalidAttributeValueException("O valor não pode ser negativo");
		}		
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCx() {
		return cx;
	}

	public void setCx(Integer cx) throws InvalidAttributeValueException {
		if (cx >= 0) {
			this.cx = cx;
		}
		else {
			throw new InvalidAttributeValueException("O valor não pode ser negativo");
		}
	}

	public Integer getCy() {
		return cy;
	}

	public void setCy(Integer cy) throws InvalidAttributeValueException {
		if (cy >= 0) {
			this.cy = cy;
		}
		else {
			throw new InvalidAttributeValueException("O valor não pode ser negativo");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POI other = (POI) obj;
		return Objects.equals(nome, other.nome);
	}	
}
