package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicelmpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id).get();
    }
    @Override
    public boolean checkClientPhone(Long id, String phone) {
        if(clientService.findClientById(id).getPhone().equals(phone)){
            return true;
        }
        return false;
    }
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);

    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }
}
