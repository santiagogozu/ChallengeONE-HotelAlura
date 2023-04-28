package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource datasource;

	public ConnectionFactory() {
		// configuramos url, usuario y contraseña
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotelalura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("");
		pooledDataSource.setMaxPoolSize(10);
		this.datasource = pooledDataSource;
		System.out.println("Entra en ConnectionFactory");
	}

	public Connection recuperaConexion() {
		System.out.println("Entra en recuperaConexion");

		try {
			System.out.println(this.datasource.getConnection());
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
