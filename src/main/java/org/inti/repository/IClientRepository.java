package org.inti.repository;

import org.inti.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Integer> {

}
