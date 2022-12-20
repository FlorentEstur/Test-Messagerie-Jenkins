package com.inti.repository;

import com.inti.model.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGerantRepository extends JpaRepository<Gerant, Integer> {

}
