package com.PCD.ReCraftMarket.model.Client;

import com.PCD.ReCraftMarket.model.Client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
@Getter @Setter @AllArgsConstructor @Builder @Table @NoArgsConstructor
@ToString @Entity
public class ImageClient implements Serializable {
    /*
         *
         */
        @Serial
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idImage;
        private String titleImage;
        //@Column(length = 420000)
        private byte[] tailleImage;
        private String typeImage;

        @OneToOne(mappedBy = "imageClient")
        @JsonIgnore
        private Client client;

    }
