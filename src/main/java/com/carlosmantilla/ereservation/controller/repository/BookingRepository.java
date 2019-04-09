package com.carlosmantilla.ereservation.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosmantilla.ereservation.model.Booking;

/**
 * Interfaz para definir las operaciones de BD relacionadas con cliente
 * 
 * @author carlosmantilla
 */

public interface BookingRepository extends JpaRepository<Booking, String> {

}
