package com.inti.repository;

import com.inti.model.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAchatRepository extends JpaRepository<Achat, Integer>{

}
