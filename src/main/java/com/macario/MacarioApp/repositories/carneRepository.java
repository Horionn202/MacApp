package com.macario.MacarioApp.repositories;

import com.macario.MacarioApp.models.CarneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carneRepository extends JpaRepository<CarneModel,Integer> {
}
