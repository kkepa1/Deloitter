package com.deloitte.deloitter.user.entity;


import com.deloitte.deloitter.dwitt.entity.Dwitt;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "login", nullable = false, length = 30)
    private String login;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_dwitt",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dwitt_id")
    )
    private Set<Dwitt> dwitts = new HashSet<>();
}
