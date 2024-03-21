package com.PCD.ReCraftMarket.model.Post;

import com.PCD.ReCraftMarket.model.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity
public class ImagePost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idImage;
    private String titleImage;
    //@Column(length = 420000)
    @Lob
    @Column(length = 1000000000)//(columnDefinition = "LONGBLOB")
    private byte[] tailleImage;
    private String typeImage;

    @ManyToOne
    @JoinColumn(name="idPost")
    @JsonIgnore
    private Post post;
}
