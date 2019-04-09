package com.carlosmantilla.ereservation.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosmantilla.ereservation.model.Client;

/**
 * Interfaz para definir las operaciones de BD relacionadas con cliente
 * 
 * @author carlosmantilla
 */

public interface ClientRepository extends JpaRepository<Client, String> {
	

}
