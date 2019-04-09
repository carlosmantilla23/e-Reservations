package com.carlosmantilla.ereservation.controller.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carlosmantilla.ereservation.model.Booking;

/**
 * Interfaz para definir las operaciones de BD relacionadas con cliente
 * 
 * @author carlosmantilla
 */

public interface BookingRepository extends JpaRepository<Booking, String> {

	@Query("SELECT r FROM Booking r WHERE r.dateInBooking =:dateInitial and r.dateOutBooking =:dateFinal")
	public List<Booking> find(@Param("dateInitial") Date dateInitial, @Param("dateFinal") Date dateFinal);

}
