package com.Myprojects.ecomm.utils;


import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import  io.jsonwebtoken.Jwts;
@Component
public class JWTUtil {

    public  static  final  String SECRET="HJFNISDUNUIFNSDUFNEW98339HN984#$#JNKJNIJSNIND";

    public String generateToken(String username)
    {
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }

    public String createToken(Map<String,Object> claims, String username){
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 30 ))
            .signWith(getSignKey(),SignatureAlgorithm.HS25).compact();
    }

    public Key getSignKey(){
        byte[] keyBytes = Decoders.Base64.Decoder(SECRET);
        return Keys.hsacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
}
