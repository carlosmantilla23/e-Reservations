package com.carlosmantilla.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * 
 * @author carlosmantilla
 */

@Data
@Entity
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idBooking;
	@Temporal(TemporalType.DATE)
	private Date dateInBooking;
	@Temporal(TemporalType.DATE)
	private Date dateOutBooking;
	private int hostQuantity;
	private String bookingDescription;
	
	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	

}
