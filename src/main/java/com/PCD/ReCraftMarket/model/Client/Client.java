package com.PCD.ReCraftMarket.model.Client;

import com.PCD.ReCraftMarket.model.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"email"})
@Entity
@Table(name = "client")
public class Client {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int idClient;
        @Column(unique = true)
        private String userName;
        private String email;
        private String password;
        private String address;
        private Number points;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "idImage", referencedColumnName = "idImage")
        private ImageClient imageClient;


        @ManyToOne
        @JoinColumn(name="idRole")
        @JsonIgnore
        private Role roles;

       @OneToMany(mappedBy = "publisher")
       @JsonIgnore
       private List<Post> postsList ;


        @ManyToMany
        @JoinTable(name = "likesList", joinColumns = @JoinColumn(name = "idClient"), inverseJoinColumns = @JoinColumn(name = "idPost"))
        @JsonIgnore
        private List<Post> LikedPosts ;

        @ManyToMany
        @JoinTable(name = "favouriteList", joinColumns = @JoinColumn(name = "idClient"), inverseJoinColumns = @JoinColumn(name = "idPost"))
        @JsonIgnore
        private List<Post> favouritePosts ;
}
