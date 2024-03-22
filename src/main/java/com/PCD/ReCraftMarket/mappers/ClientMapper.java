package com.PCD.ReCraftMarket.mappers;

import com.PCD.ReCraftMarket.dto.ClientRequest;
import com.PCD.ReCraftMarket.model.Client.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toEntity(ClientRequest clientRequest) {
        return Client.builder()
                .userName(clientRequest.getUserName())
                .email(clientRequest.getEmail())
                .roles(clientRequest.getRoles())
                .address(clientRequest.getAddress())
                .password(clientRequest.getPassword())
                .imageClient(clientRequest.getImageClient())
                .build();
    }

    public ClientRequest toDto(Client client) {
        return ClientRequest.builder()
                .userName(client.getUserName())
                .email(client.getEmail())
                .roles(client.getRoles())
                .address(client.getAddress())
                .imageClient(client.getImageClient())
                .build();
    }
}
