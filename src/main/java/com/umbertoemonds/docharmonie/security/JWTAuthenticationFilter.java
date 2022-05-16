package com.umbertoemonds.docharmonie.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umbertoemonds.docharmonie.model.dto.in.LoginDTOIn;
import com.umbertoemonds.docharmonie.model.dto.out.UtilisateurDTOOut;
import com.umbertoemonds.docharmonie.utils.SecurityConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final static Log LOG = LogFactory.getLog(JWTAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl(SecurityConstants.SIGN_IN_URL);
    }

   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
           throws AuthenticationException {

        try{
            LoginDTOIn loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTOIn.class);
            
            var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword(), new ArrayList<>());
            var result = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            
            return result;
        } catch (IOException e){
            throw new RuntimeException("Erreur lors de la lecture et du parsing de la requete: " +  e.getMessage());
        }
   }

   @Override
   protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
           Authentication authResult) throws IOException, ServletException {

            UtilisateurDTOOut userDetails = (UtilisateurDTOOut) authResult.getPrincipal();

            String token = JWT.create()
                        .withSubject(String.valueOf(userDetails.getId()))
                        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                        .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

            response.getWriter().write(token);
            response.getWriter().flush();
   }

}