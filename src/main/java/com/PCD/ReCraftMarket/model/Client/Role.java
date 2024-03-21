package com.PCD.ReCraftMarket.model.Client;

import com.PCD.ReCraftMarket.model.Client.NameRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Entity @Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Enumerated(EnumType.STRING)
    private NameRole nameRole;
    @OneToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Client> clientSet;
}
