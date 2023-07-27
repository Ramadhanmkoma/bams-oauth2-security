package com.biometric.bams.exception;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Tuesday, 25 July 2023
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
