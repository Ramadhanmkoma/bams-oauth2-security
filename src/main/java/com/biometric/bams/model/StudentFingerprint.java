package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity(name = "bams_student_fingerprint")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentFingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finger_id;

    /*To get JPA to stream the binary data into this field*/
    //@Type(type="org.hibernate.type.BinaryType")     //needed to help hibernate deal with binary data
    @Lob  //large objects (lob): Binary data can get really large.
    private Byte[] fingerprint_recog;

    public Byte[] getFingerprint_recog() {
        return fingerprint_recog;
    }

    public void setFingerprint_recog(Byte[] fingerprint_recog) {
        this.fingerprint_recog = fingerprint_recog;
    }
}
