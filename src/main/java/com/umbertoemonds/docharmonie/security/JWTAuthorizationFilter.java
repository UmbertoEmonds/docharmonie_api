package com.umbertoemonds.docharmonie.security;

import java.io.IOException;
import java.util.ArrayList;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.umbertoemonds.docharmonie.utils.SecurityConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final static Log LOG = LogFactory.getLog(JWTAuthorizationFilter.class);

    public JWTAuthorizationFilter(AuthenticationManager authManager){
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);

        if(token == null) {
            chain.doFilter(request, response);
        }else {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);

        if(token != null){
            String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                                .build()
                                .verify(token)
                                .getSubject();

            if(user != null){
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            
            return null;
        }

        return null;
    }

}