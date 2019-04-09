package com.carlosmantilla.ereservation.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosmantilla.ereservation.model.Client;

/**
 * Interfaz para definir las operaciones de BD relacionadas con cliente
 * 
 * @author carlosmantilla
 */

public interface ClientRepository extends JpaRepository<Client, String> {

	/** Definicon de metodo para buscar los cliente por apellido */
	public List<Client> findByClientSurname(String clientSurname);

	public Client findByClientId(String clientId);
	

}
