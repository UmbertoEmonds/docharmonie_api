package com.umbertoemonds.docharmonie.controller;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;
import com.umbertoemonds.docharmonie.model.Grille;
import com.umbertoemonds.docharmonie.model.dto.in.GrilleDTOIn;
import com.umbertoemonds.docharmonie.model.dto.out.GrilleDTOOut;
import com.umbertoemonds.docharmonie.service.GrilleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.umbertoemonds.docharmonie.security.JWTAuthenticationFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

@RestController
@RequestMapping("/grilles")
public class GrilleController {
    
    private final static Log LOG = LogFactory.getLog(JWTAuthenticationFilter.class);

    @Autowired
    private GrilleService grilleService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Accord>> findAccords(@PathVariable("id") Integer id){
        List<Accord> accords = grilleService.findAccordsByGrilleId(id);

        if(accords == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Accord>>(accords, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Grille>> findAll(){

        if(SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken user){
            String userId = user.getName();

            if(userId != null){
                List<Grille> grilles = grilleService.findAllByUserId(Integer.parseInt(userId));

                if(grilles == null){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

                return ResponseEntity.ok(grilles);
            }
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}