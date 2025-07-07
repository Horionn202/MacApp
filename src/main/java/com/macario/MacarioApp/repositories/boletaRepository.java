package com.macario.MacarioApp.repositories;

import com.macario.MacarioApp.models.BoletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface boletaRepository extends JpaRepository<BoletaModel, Integer> {
}