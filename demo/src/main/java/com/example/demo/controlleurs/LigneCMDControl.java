package com.example.demo.controlleurs;


import com.example.demo.entities.LigneCMD;
import com.example.demo.services.LignCmdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lignescmd")
public class LigneCMDControl {

    @Autowired
    private LignCmdService ligneCMDService;

    @GetMapping("/commande/{idCMD}")
    public List<LigneCMD> getLignesByCommande(@PathVariable Long idCMD) {
        return ligneCMDService.getLignesByCommande(idCMD);
    }
}
