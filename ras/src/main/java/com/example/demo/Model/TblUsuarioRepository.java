package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblUsuarioRepository extends JpaRepository<TblUsuario, Integer> {
    TblUsuario findByEmail(String email);
}