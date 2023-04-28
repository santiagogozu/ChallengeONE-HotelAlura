package com.alura.jdbc.modelo;

import java.sql.Date;

public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String telefono;
	private String idReserva;

	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String telefono,
			String idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String telefono,
			String idReserva) {
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

}