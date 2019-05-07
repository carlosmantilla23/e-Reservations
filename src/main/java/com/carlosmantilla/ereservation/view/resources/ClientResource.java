/**
 * 
 */
package com.carlosmantilla.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosmantilla.ereservation.controller.services.ClientService;
import com.carlosmantilla.ereservation.model.Client;
import com.carlosmantilla.ereservation.view.resources.vo.ClientVO;

/**
 * @author carlosmantilla Clase que representa el web service de cliente el cual
 *         va a exponer las operaciones
 *
 */
@RestController
@RequestMapping("/api/client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
		Client client = new Client();
		client.setClientName(clientVo.getClientName());
		client.setClientSurname(clientVo.getClientSurname());
		client.setClientAddress(clientVo.getClientAddress());
		client.setClientPhone(clientVo.getClientPhone());
		client.setClientMail(clientVo.getClientMail());

		return new ResponseEntity<>(this.clientService.createClient(client), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") String id, ClientVO clientVo) {

		Client client = this.clientService.findByClientId(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setClientName(clientVo.getClientName());
			client.setClientSurname(clientVo.getClientSurname());
			client.setClientAddress(clientVo.getClientAddress());
			client.setClientPhone(clientVo.getClientPhone());
			client.setClientMail(clientVo.getClientMail());

			return new ResponseEntity<>(this.clientService.updateClient(client), HttpStatus.OK);

		}
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") String id) {

		Client client = this.clientService.findByClientId(id);
		if (client != null) {
			this.clientService.deleteClient(client);
		}

	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
