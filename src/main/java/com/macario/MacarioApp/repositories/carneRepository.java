package com.macario.MacarioApp.repositories;

import com.macario.MacarioApp.models.carneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carneRepository extends JpaRepository<carneModel,Integer> {
}
