package com.deloitte.deloitter.dwitt.entity;

import com.deloitte.deloitter.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dwitts")
public class Dwitt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;
}
