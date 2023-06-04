package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LecturerFingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fingerprint_id;

    @Lob    //    @Type(type="org.hibernate.type.BinaryType")
    private Byte[] fingerprint_recog;

}
