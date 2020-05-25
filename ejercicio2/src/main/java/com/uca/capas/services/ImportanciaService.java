package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;


import com.uca.capas.domain.Importancia;

public interface ImportanciaService {
	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer c_importancia) throws DataAccessException;

	//Importancia findOne(Integer code) throws DataAccessException;

	//public Importancia findOne(Importancia importancia);

}
