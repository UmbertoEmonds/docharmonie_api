package com.umbertoemonds.docharmonie.service;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;
import com.umbertoemonds.docharmonie.model.Grille;
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
        return grilleRepository.findAllByUserId(userId);
    }

    public List<Accord> findAccordsByGrilleId(Integer grilleId){
        return accordRepository.findAllByGrilleIdOrderByPositionAsc(grilleId);
    }

}