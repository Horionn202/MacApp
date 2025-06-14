package com.macario.MacarioApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.macario.MacarioApp.models.userModel;
@Repository

public interface userRepository  extends  JpaRepository<userModel, Integer>{
    userModel findByEmail(String email);
}
