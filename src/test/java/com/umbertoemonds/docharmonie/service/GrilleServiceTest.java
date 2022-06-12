package com.umbertoemonds.docharmonie.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.umbertoemonds.docharmonie.AbstractTest;

public class GrilleServiceTest extends AbstractTest {
    
    @Test
    protected void findAll(){
        var result = grilleService.findAllByUserId(1);
        Assertions.assertNotNull(result);
    }

    @Test
    protected void findAccordsForFirstGrille(){
        var result = grilleService.findAccordsByGrilleId(1);
        Assertions.assertNotNull(result, "Results must exists");
    }

}