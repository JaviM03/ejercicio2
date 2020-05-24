package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	private Integer codigo;
	
	@Column(name="s_importancia")
	private String s_importancia;
	
	@OneToMany(mappedBy="importancia",fetch=FetchType.EAGER)
	private List<Contribuyente> contribuyentes;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getS_importancia() {
		return s_importancia;
	}

	public void setS_importancia(String s_importancia) {
		this.s_importancia = s_importancia;
	}
	
	public Importancia() {
		
	}
}
