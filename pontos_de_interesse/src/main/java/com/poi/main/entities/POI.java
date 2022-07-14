package com.poi.main.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.management.InvalidAttributeValueException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pois")
public class POI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "cx")
	private Integer cx;
	
	
	@Column(name = "cy")
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
