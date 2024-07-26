package com.example.ecommerce.service;

import com.example.ecommerce.model.Client;
import com.example.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client existingClient = client.get();
            existingClient.setName(clientDetails.getName());
            existingClient.setEmail(clientDetails.getEmail());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
