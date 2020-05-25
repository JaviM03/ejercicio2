package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer codigo;
	
	
	@Size(message="Este campo acepta solamente 30 caracteres", max=30)
	@NotEmpty(message="Este campo no puede ser vacio")
	@Column(name="s_nombre")
	private String nombre;
	
	
	@Size(message="Este campo acepta solamente 30 caracteres", max=30)
	@NotEmpty(message="Este campo no puede ser vacio")
	@Column(name="s_apellido")
	private String apellido;
	
	@Size(message="Este campo acepta solamente 14 caracteres", max=14)
	@NotEmpty(message="Este campo no puede ser vacio")
	@Column(name="s_nit")
	private String nit;
	
	@Transient
	private Integer c_importancia;
	
	@Temporal(TemporalType.DATE)
	@Column(name="f_fecha_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date f_fecha_ingreso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	

	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getF_fecha_ingreso() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(f_fecha_ingreso);
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}


	public Contribuyente() {
		
	}
	
	
	
}
