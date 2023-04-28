package com.alura.jdbc.controller;

import java.sql.SQLException;
import java.util.List;

import com.alura.jdbc.dao.ReservasDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Reserva;

public class ReservasController {

	private ReservasDAO reservasDao;

	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDao = new ReservasDAO(factory.recuperaConexion());
	}

	public void guardar(Reserva nuevaReserva) {
		reservasDao.guardar(nuevaReserva);
	}
	
	 public List<Reserva> listar() {
	        return reservasDao.listar();
	 }

}
