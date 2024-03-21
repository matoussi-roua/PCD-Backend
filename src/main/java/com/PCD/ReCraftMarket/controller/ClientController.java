package com.PCD.ReCraftMarket.controller;

import com.PCD.ReCraftMarket.dto.ClientRequest;
import com.PCD.ReCraftMarket.model.Client.Client;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.PCD.ReCraftMarket.services.ClientServices;

import java.util.List;

@RequestMapping("/API/Client")
@RestController

public class ClientController {

    private final ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest clientRequest){
        clientServices.createClient(clientRequest);
    }
    //@ApiOperation(value = "Get example data", notes = "This endpoint retrieves example data.")
    @PutMapping("/{id}")
    //@ApiParam(value = "ID of the example data", required = true)
    public ResponseEntity<Client> updateClient( @PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        Client updatedClient = clientServices.updateClient(id, clientRequest);
        return ResponseEntity.ok(updatedClient);
    }
    //@ApiOperation(value = "Get example data", notes = "This endpoint retrieves example data.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient( @PathVariable Long id) {
        clientServices.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
    //@ApiOperation(value = "Get example data", notes = "This endpoint retrieves example data.")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientServices.getClientById(id);
        return ResponseEntity.ok(client);
    }
    //@ApiOperation(value = "Get example data", notes = "This endpoint retrieves example data.")
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientServices.getAllClients();
        return ResponseEntity.ok(clients);
    }
    @GetMapping("/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable String email) {
        Client client = clientServices.getClientByEmail(email);
        return ResponseEntity.ok(client);
    }
}
