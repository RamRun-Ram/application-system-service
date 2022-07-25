package com.example.applicationsystemservice.service;

public interface JwtTokenService {

    String generateToken(String owner, String ownerRole);

    boolean isValid(String token);

    String getOwner(String token);

}
