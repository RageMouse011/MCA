package kz.dar.tech.clientcoreapi.controller;

import kz.dar.tech.clientcoreapi.dto.ClientDTO;
import kz.dar.tech.clientcoreapi.entity.Client;
import kz.dar.tech.clientcoreapi.repository.ClientRepository;
import kz.dar.tech.clientcoreapi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientEmail}")
    public Client getClient(
            @PathVariable(name = "clientEmail") String email
    ) {
        return clientService.getClient(email);
    }

    @PostMapping("/add")
    public Client addClient(
            @RequestBody ClientDTO clientDTO
    ) {
        return clientService.addClient(clientDTO);
    }

    @PutMapping("/update/{clientEmail}")
    public Client updateClient(
            @PathVariable(name = "clientEmail") String email,
            @RequestBody ClientDTO clientDTO
    ) {
        return clientService.updateClient(email, clientDTO);
    }
    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(
            @PathVariable(name = "clientId") Long clientId
    ) {
        clientService.deleteClient(clientId);
    }
}
