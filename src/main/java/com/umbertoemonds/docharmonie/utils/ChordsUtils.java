package com.umbertoemonds.docharmonie.utils;

import java.util.HashMap;

public class ChordsUtils {

    public static HashMap<String, int[]> CHORD_INTERVAL = new HashMap<>(){{
        put("maj", new int[]{4, 7});
        put("(b5)", new int[]{4, 6});
        put("maj7", new int[]{4, 7, 11});
        put("maj6", new int[]{4, 7, 11, 9});
        put("maj9", new int[]{4, 7, 11, 2});
        put("maj9(#11)", new int[]{4, 7, 11, 2, 6});
        put("9",    new int[]{4, 7, 10, 2});
        put("13", new int[]{4, 7, 10, 2, 5, 9});
        put("min", new int[]{3, 7});
        put("min7", new int[]{3, 7, 10});
        put("min9", new int[]{3, 7, 10, 2});
        put("min(b7,9,11)", new int[]{3, 7, 9, 2, 5});
        put("maj(b7,9,11)", new int[]{4, 7, 9, 2, 5});
        put("maj(b7,b9,11)", new int[]{4, 7, 9, 1, 5});
        put("aug(b7,9,11)", new int[]{4, 8, 9, 2, 5});
        put("7", new int[]{4, 7, 10});
        put("7(b9)", new int[]{4, 7, 10, 1});
        put("7(b13)", new int[]{4, 7, 10, 8});
        put("dim", new int[]{3, 6});
        put("aug", new int[]{4, 8});
        put("aug(b7)", new int[]{4, 8, 9});
        put("aug(7)", new int[]{4, 8, 10});
        put("aug(b7,9)", new int[]{4, 8, 9, 2});
        put("hdim", new int[]{3, 6, 10});
        put("sus4", new int[]{5, 7});
        put("sus4(b7)", new int[]{5, 7, 9});
        put("sus4(b7,9)", new int[]{5, 7, 9, 2});
        put("sus4(b7,b9)", new int[]{5, 7, 9, 1});
        put("6", new int[]{4, 7, 9});
        put("6(9)", new int[]{4, 7, 9, 2});
        put("min6", new int[]{3, 7, 9});
        put("min6(9)", new int[]{3, 7, 9, 2});
        put("(1,5)", new int[]{7});
        put("(1,4)", new int[]{7});
    }};


    public static HashMap<String, Integer> NOTES = new HashMap<>(){{
        put("C", 0);
        put("C#", 1);
        put("Db", 1);
        put("D", 2);
        put("D#", 3);
        put("Eb", 3);
        put("E", 4);
        put("F", 5);
        put("F#", 6);
        put("Gb", 6);
        put("G", 7);
        put("G#", 8);
        put("Ab", 8);
        put("A", 9);
        put("A#", 10);
        put("Bb", 10);
        put("B", 11);
    }};
}
