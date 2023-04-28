package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Huespedes;
import com.alura.jdbc.modelo.Reserva;

public class ReservasDAO {

	private Connection con;

	public ReservasDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO reservas " + "(fechaEntrada, fechaSalida, valor, formaPago)" + " VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				System.out.println(reserva.getFechaEntrada());
				System.out.println(reserva.getFechaSalida());
				System.out.println(reserva.getValor());
				System.out.println(reserva.getFormaPago());

				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setString(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());

				statement.execute();

				System.out.println(statement);
				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));

					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reserva> listar() {
		List <Reserva> reserva = new ArrayList<Reserva>();
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, fechaEntrada, fechaSalida, valor, formaPago FROM reservas");
			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						reserva.add(new Reserva(resultSet.getInt("id"), resultSet.getDate("fechaEntrada"),
								resultSet.getDate("fechaSalida"), resultSet.getString("valor"),
								resultSet.getString("formaPago")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return reserva;
	}

}
