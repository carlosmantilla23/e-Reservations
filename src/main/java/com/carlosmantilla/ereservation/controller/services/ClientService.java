/**
 * 
 */
package com.carlosmantilla.ereservation.controller.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlosmantilla.ereservation.controller.repository.ClientRepository;
import com.carlosmantilla.ereservation.model.Client;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author carlosmantilla
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;

	}

	/**
	 * Metodo para realizar la operacion de guardar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Client createClient(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un cliente
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client updateClient(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un cliente
	 * 
	 * @param client
	 */
	@Transactional
	public void deleteClient(Client client) {
		this.clientRepository.delete(client);
	}

	/**
	 * Metodo para consultar un cliente por su DNI
	 * 
	 * @param clientId
	 * @return
	 */
	public Client findByClientId(String clientId) {
		return this.clientRepository.findByClientId(clientId);
	}

}
