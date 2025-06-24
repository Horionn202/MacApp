package com.macario.MacarioApp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.macario.MacarioApp.models.PedidoModel;

@Repository
public interface pedidoRepository extends JpaRepository<PedidoModel, Integer> {

}
  