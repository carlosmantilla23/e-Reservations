/**
 * 
 */
package com.carlosmantilla.ereservation.view.resources.vo;

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
 * 
 * @author carlosmantilla
 *
 */

@Data // Lombok
public class ClientVO {

	private String clientName;
	private String clientSurname;
	private String clientDni;
	private String clientAddress;
	private String clientPhone;
	private String clientMail;

}
