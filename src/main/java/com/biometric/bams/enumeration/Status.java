package com.biometric.bams.enumeration;

public enum Status {
    ATTENDED("ATTENDED"),
    MISSED("MISSED");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
