package org.inti.repository;

import org.inti.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Integer> {

}
