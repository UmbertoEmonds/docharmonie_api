package com.umbertoemonds.docharmonie.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;
import com.umbertoemonds.docharmonie.model.Grille;
import com.umbertoemonds.docharmonie.model.dto.in.GrilleDTOIn;
import com.umbertoemonds.docharmonie.model.dto.out.AccordDTOOut;
import com.umbertoemonds.docharmonie.repository.AccordRepository;
import com.umbertoemonds.docharmonie.repository.GrilleRepository;
import com.umbertoemonds.docharmonie.utils.ChordsUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GrilleService {
    
    @Autowired
    private GrilleRepository grilleRepository;

    @Autowired
    private AccordRepository accordRepository;

    @Autowired
    private WebClient iaWebClient;

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(20);

    private List<String> getAndPurgeAccords(String diversite){
        String[] chordsResponse = iaWebClient
            .get()
            .uri("/chords")
            .header("diversity", diversite)
            .retrieve()
            .bodyToMono(String[].class)
            .block(REQUEST_TIMEOUT);

        List<String> chordsResponseAR = Arrays.asList(chordsResponse);
        List<String> result = new ArrayList<>();

        chordsResponseAR.forEach(chord -> {
            String purged;

            purged = StringUtils.substringBefore(chord, "/");

            purged = purged.replace("maj(b7,9,11,13)", "maj(b7,9,11)");
            purged = purged.replace("maj(b7,s9,11,13)", "maj(b7,9,11)");
            purged = purged.replace("aug(b7,9,11,13)", "aug(b7,9,11)");
            purged = purged.replace("7(s5,*5,s9)", "9");
            purged = purged.replace("maj(b7,9,s11,13)", "maj(b7,9,11)");
            purged = purged.replace("(1,3,b5,b7,9,13)", "(b5)");
            purged = purged.replace("(1,4,5,b7,9,11,13)", "sus4(b7,9)");
            purged = purged.replace("(1,3,s5,b7,9,11,13)", "sus4(b7,9)");
            purged = purged.replace("(1,3,s5,b7,b9,11,13)", "sus4(b7,b9)");
            purged = purged.replace("7(b5,*5)", "7");
            purged = purged.replace("7(b5,*5,s9)", "7");
            purged = purged.replace("7(s9)", "9");
            purged = purged.replace("maj(7,9,11,13)", "maj9");
            purged = purged.replace("maj(7,9,s11,13)", "maj9");
            purged = purged.replace("min(b7,9,11,13)", "min(b7,9,11)");
            purged = purged.replace("maj(b7,b9,11,13)", "maj(b7,b9,11)");
            purged = purged.replace("maj(b7,b9,s11,13)", "maj(b7,b9,11)");
            purged = purged.replace("7(s9,s11,b13)", "9");
            purged = purged.replace("7(s9,b13)", "9");
            purged = purged.replace("7(s5,*5,b9)", "7(b9)");
            purged = purged.replace("(s5,*5)", "");
            purged = purged.replace("9(b5,*5)", "9");
            purged = purged.replace("(b5,*5,b9)", "");
            purged = purged.replace("(b9,s11)", "");
            purged = purged.replace("(2,*3)", "");
            purged = purged.replace("min(7)", "min7");
            purged = purged.replace("9(s11)", "9");
            purged = purged.replace("7(s11)", "7");
            purged = purged.replace("(1,b3,b5)", "dim");
            purged = purged.replace("min(6,9)", "min6(9)");
            

            result.add(purged);
        });

        return result;
    }

    public List<AccordDTOOut> generate(String diversite){
        
        List<String> chordsResponse = getAndPurgeAccords(diversite);

        chordsResponse.forEach(e -> {
            System.out.println(e);
        });

        List<AccordDTOOut> accordsResponse = new ArrayList<>();

        for (int i = 0; i < chordsResponse.size(); i++){
            AccordDTOOut accord = new AccordDTOOut();

            String acc = chordsResponse.get(i);

            int[] demi_tons = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            String[] accSplit = acc.split(":");

            String root = accSplit[0];
            String nature = accSplit[1];

            int chord_root = ChordsUtils.NOTES.get(root);
            int[] chord_nature = ChordsUtils.CHORD_INTERVAL.get(nature);

            if(chord_nature == null){
                System.out.println("NULL: " + nature);
            }

            // assignation de la fondamentale
            demi_tons[chord_root] = 1;

            // assingnation des notes
            for(int j = 0; j < chord_nature.length; j++){
                int interval = chord_nature[j];

                if(chord_root + interval > 11){
                    demi_tons[(chord_root + interval) - 12] = 1;
                }else {
                    demi_tons[chord_root + interval] = 1;
                }
            }

            accord.setDemiTons(demi_tons);
            accord.setPosition(i);
            accord.setRawName(acc);
            accordsResponse.add(accord);
        }

        return accordsResponse;
    }

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