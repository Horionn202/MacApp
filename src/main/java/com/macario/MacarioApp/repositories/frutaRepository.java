package com.macario.MacarioApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.macario.MacarioApp.models.FrutaModel;
import org.springframework.stereotype.Repository;

@Repository
public interface frutaRepository extends JpaRepository<FrutaModel,Integer> {

}

