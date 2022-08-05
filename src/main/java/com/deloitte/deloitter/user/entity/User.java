package com.deloitte.deloitter.user.entity;


import com.deloitte.deloitter.dwitt.entity.Dwitt;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Set<Dwitt> dwitts = new HashSet<>();
}
