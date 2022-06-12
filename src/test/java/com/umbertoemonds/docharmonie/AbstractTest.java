package com.umbertoemonds.docharmonie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.umbertoemonds.docharmonie.service.GrilleService;
import com.umbertoemonds.docharmonie.service.UtilisateurService;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractTest {
    
    @Autowired
    protected GrilleService grilleService;
    
    @Autowired
    protected UtilisateurService utilisateurService;

}