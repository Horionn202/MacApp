package com.macario.MacarioApp.repositories;

import org.springframework.stereotype.Repository;
import com.macario.MacarioApp.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface productoRepository extends JpaRepository<ProductoModel, Integer> {

}