package com.macario.MacarioApp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.macario.MacarioApp.models.AdicionalModel;


@Repository
public interface adicionalRepository extends JpaRepository<AdicionalModel, Integer> {

}