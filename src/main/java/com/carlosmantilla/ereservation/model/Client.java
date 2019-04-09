/**
 * 
 */
package com.carlosmantilla.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Client
 * @author carlosmantilla
 *
 */

@Data //Lombok
@Entity //Permite que esta clase represente una tabla en BD
@Table (name = "client") //A cual tabla va a mapearse
@NamedQuery(name="Client.findByClientId", query = "SELECT c FROM Cliente c WHERE c.clientDni = ?1")
public class Client {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String clientId;
	private String clientName;
	private String clientSurname;
	private String clientDni;
	private String clientAddress;
	private String clientPhone;
	private String clientMail;
	
	@OneToMany (mappedBy= "client")//Un cliente tiene muchas reservas
	private Set<Booking> bookings;
	
	
	public Client() {
	
	}
	
	
	
	

}
