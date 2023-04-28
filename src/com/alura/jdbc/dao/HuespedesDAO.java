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

public class HuespedesDAO {

	private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement("INSERT INTO huespedes "
					+ "(nombre, apellido, fechaNacimiento, telefono, idReserva)" + " VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechaNacimiento());
				statement.setString(4, huespedes.getTelefono());
				statement.setString(5, huespedes.getIdReserva());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));

					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, nombre, apellido, fechaNacimiento, telefono, idReserva FROM huespedes");
			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						huespedes.add(new Huespedes(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getDate("fechaNacimiento"),
								resultSet.getString("telefono"), resultSet.getString("idReserva")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return huespedes;
	}

}