package com.biometric.bams.controller.login;

import com.biometric.bams.model.Lecturer;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.Date;

public class JwtTokenProvider {
    private static final String SECRET_KEY = "your_secret_key";
    private static final long EXPIRATION_TIME = 86400000L; // 24 hhours

    public String generateToken(Authentication authentication) {
//        Lecturer lecturer = (Lecturer) authentication.getClass().getProtectionDomain().getPrincipals();
        Date now = new Date();
        Date expiryDate = new Date();
        return "";
    }

}
