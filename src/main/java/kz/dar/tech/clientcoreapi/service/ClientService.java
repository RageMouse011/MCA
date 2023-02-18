package kz.dar.tech.clientcoreapi.service;

import kz.dar.tech.clientcoreapi.dto.ClientDTO;
import kz.dar.tech.clientcoreapi.entity.Client;
import kz.dar.tech.clientcoreapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(
            String email
    ) {
        return clientRepository.findClientByEmail(email);
    }

    public Client addClient(
            ClientDTO clientDTO
    ) {
        if (clientRepository.existsByEmail(clientDTO.getEmail())) {
            throw new IllegalStateException("This email has already been in system.");
        }

        Client client = Client.builder()
                .name(clientDTO.getName())
                .surname(clientDTO.getSurname())
                .email(clientDTO.getEmail())
                .build();
        return clientRepository.save(client);
    }

    public Client updateClient(
            String email,
            ClientDTO clientDTO
    ) {
        Client client = clientRepository.findClientByEmail(email);
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setEmail(clientDTO.getEmail());
        return clientRepository.save(client);
    }

    public void deleteClient(
            Long clientId
    ) {
        clientRepository.deleteById(clientId);
    }


}
