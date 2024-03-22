package com.PCD.ReCraftMarket.services;

import com.PCD.ReCraftMarket.dto.ClientRequest;
import com.PCD.ReCraftMarket.mappers.ClientMapper;
import com.PCD.ReCraftMarket.model.Client.Client;
import com.PCD.ReCraftMarket.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServices {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void createClient(ClientRequest clientRequest){
        Client client = clientMapper.toEntity(clientRequest);
        clientRepository.save(client);
    }

    public Client updateClient(Long clientId, ClientRequest clientRequest) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setUserName(clientRequest.getUserName());
            client.setEmail(clientRequest.getEmail());
            client.setRoles(clientRequest.getRoles());
            client.setAddress(clientRequest.getAddress());
            client.setImageClient(clientRequest.getImageClient());
            return(clientRepository.save(client));
        } else {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}