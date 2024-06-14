package com.example.demo.services;

import com.example.demo.entities.LigneCMD;
import com.example.demo.repository.LignCmdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// LignCmdService.java
@Service
public class LignCmdService {
    @Autowired
    private LignCmdRepo LignCmdRepo;

    public LigneCMD saveLignCmd(LigneCMD LignCmd) {
        return LignCmdRepo.save(LignCmd);
    }

    public LigneCMD updateLignCmd(LigneCMD LignCmd) {
        return LignCmdRepo.save(LignCmd);
    }

    public void deleteLignCmd(Long id) {
        LignCmdRepo.deleteById(id);
    }

    public List<LigneCMD> getAllLignCmds() {
        return LignCmdRepo.findAll();
    }

    public LigneCMD getLignCmdById(Long id) {
        return LignCmdRepo.findById(id).orElse(null);
    }
    public List<LigneCMD> getLignesByCommande(Long idCMD) {
        return LignCmdRepo.findByCommandeIdCMD(idCMD);
    }
}


