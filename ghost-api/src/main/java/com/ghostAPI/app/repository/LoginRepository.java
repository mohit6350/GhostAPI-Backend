package com.ghostAPI.app.repository;

import com.ghostAPI.app.requestModel.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {



}
