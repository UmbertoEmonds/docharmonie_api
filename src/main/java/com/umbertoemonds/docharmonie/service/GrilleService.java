package com.umbertoemonds.docharmonie.service;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;
import com.umbertoemonds.docharmonie.model.Grille;
import com.umbertoemonds.docharmonie.model.dto.in.GrilleDTOIn;
import com.umbertoemonds.docharmonie.repository.AccordRepository;
import com.umbertoemonds.docharmonie.repository.GrilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrilleService {
    
    @Autowired
    private GrilleRepository grilleRepository;

    @Autowired
    private AccordRepository accordRepository;

    public List<Grille> findAllByUserId(Integer userId){
        List<Grille> grillesFromDB =  grilleRepository.findAllByUserId(userId);
        return grillesFromDB;
        /*
        List<GrilleDTOOut> grillesDTOOut = grillesFromDB.stream().map(grille -> {
            GrilleDTOOut grilleDTOOut = new GrilleDTOOut();

            Projet projet;
            String tonaliteNote;
            String tonaliteMode;
            String style;



            grilleDTOOut.setId(grille.getId());
            grilleDTOOut.setNom(grille.getNom());
            grilleDTOOut.setTempo(grille.getTempo());
            grilleDTOOut.setTonalite_note(tonaliteNote);
            grilleDTOOut.setTonalite_mode(tonaliteMode);
            grilleDTOOut.setProjet(projet);
            grilleDTOOut.setStyle(style);

            return grilleDTOOut;
        }).collect(Collectors.toList());

        return grillesDTOOut;
         */
    }

    public List<Accord> findAccordsByGrilleId(Integer grilleId){
        return accordRepository.findAllByGrilleIdOrderByPositionAsc(grilleId);
    }

    public void add(GrilleDTOIn grilleDTOIn){
        // TODO : ajout d'une grille
    }
    
}