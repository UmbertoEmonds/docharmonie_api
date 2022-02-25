package com.umbertoemonds.docharmonie.controller;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;
import com.umbertoemonds.docharmonie.service.GrilleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grilles")
public class GrilleController {
    
    @Autowired
    private GrilleService grilleService;

    @GetMapping("/{id}")
    public List<Accord> findAccords(@PathVariable("id") Integer id){
        return grilleService.findAccordsByGrilleId(id);
    }

}