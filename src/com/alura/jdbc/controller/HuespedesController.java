package com.alura.jdbc.controller;

import java.sql.SQLException;
import java.util.List;

import com.alura.jdbc.dao.HuespedesDAO;
import com.alura.jdbc.dao.ReservasDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huespedes;
import com.alura.jdbc.modelo.Reserva;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;

	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedesDAO = new HuespedesDAO(factory.recuperaConexion());
	}

	public void guardar(Huespedes huespedNuevo) {
		huespedesDAO.guardar(huespedNuevo);

	}
	
	 public List<Huespedes> listar() {
	        return huespedesDAO.listar();
	 }

}
