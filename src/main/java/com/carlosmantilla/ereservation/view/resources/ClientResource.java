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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author carlosmantilla Clase que representa el web service de cliente el cual
 *         va a exponer las operaciones
 *
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Create Client", notes = "Service for clients creation")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully client creation"),
			@ApiResponse(code = 400, message = "Invalid Request") })
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
	@ApiOperation(value = "Update Client", notes = "Service for clients updating")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully client update"),
			@ApiResponse(code = 400, message = "Invalid Request") })
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
	@ApiOperation(value = "Remove Client", notes = "Service for clients remove")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully client removed"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public void deleteClient(@PathVariable("id") String id) {

		Client client = this.clientService.findByClientId(id);
		if (client != null) {
			this.clientService.deleteClient(client);
		}

	}

	@GetMapping
	@ApiOperation(value = "Show All Clients", notes = "Service for list all clients")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully clients listed"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
