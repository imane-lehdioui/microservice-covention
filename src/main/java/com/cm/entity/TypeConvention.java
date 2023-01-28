package com.cm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conv_typeConvention")
public class TypeConvention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;

	@OneToMany(mappedBy = "typeConvention", cascade = CascadeType.ALL)
	private Set<Convention> conventions;

	public TypeConvention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeConvention(String libelle) {
		super();
		this.libelle = libelle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}