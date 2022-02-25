package com.umbertoemonds.docharmonie.utils;

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins, bonne pratique pour eviter les attaques brute force
    public static final String TOKEN_HEADER = "Authorization";
    public static final String SIGN_IN_URL = "/login";
    public static final String SIGN_UP_URL = "/users";
}