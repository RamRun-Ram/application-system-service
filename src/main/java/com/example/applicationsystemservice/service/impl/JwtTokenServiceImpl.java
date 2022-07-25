package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.service.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.applicationsystemservice.utils.DateTimeUtils.convertToDate;
import static com.example.applicationsystemservice.utils.DateTimeUtils.convertToLocalDateTime;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    private static final String SIGNING_KEY = "SHIGAPOV_RAMIL";
    @Override
    public String generateToken(String owner, String ownerRole) {
        LocalDateTime issued = LocalDateTime.now();
        LocalDateTime expiration = issued.plusHours(1);
        return Jwts.builder()
                .setIssuer(owner)
                .setSubject(ownerRole)
                .setIssuedAt(convertToDate(issued))
                .setExpiration(convertToDate(expiration))
                .signWith(SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(SIGNING_KEY))
                .compact();
    }

    @Override
    public boolean isValid(String token) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime issued = convertToLocalDateTime(Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getIssuedAt());
        LocalDateTime expiration = convertToLocalDateTime(Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration());
        return now.isAfter(issued) && now.isBefore(expiration);
    }

    @Override
    public String getOwner(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getIssuer();
    }

}
