package kz.dar.tech.clientcoreapi.repository;

import kz.dar.tech.clientcoreapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);

    Client findClientByEmail(String email);
}
