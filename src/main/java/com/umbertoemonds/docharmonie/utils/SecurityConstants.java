package com.umbertoemonds.docharmonie.utils;

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 1800000; // 30 mins
    public static final String TOKEN_HEADER = "Authorization";
    public static final String SIGN_IN_URL = "/login";
    public static final String SIGN_UP_URL = "/users";
}