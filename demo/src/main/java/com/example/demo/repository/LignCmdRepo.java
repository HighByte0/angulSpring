package com.example.demo.repository;

import com.example.demo.entities.LigneCMD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LignCmdRepo extends JpaRepository<LigneCMD, Long> {
    List<LigneCMD> findByCommandeIdCMD(Long idCMD);
}