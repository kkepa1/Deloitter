package com.deloitte.deloitter.dwitt.entity;

import com.deloitte.deloitter.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dwitts")
public class Dwitt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "dwitts"
    )
    private Set<User> users = new HashSet<>();
}
