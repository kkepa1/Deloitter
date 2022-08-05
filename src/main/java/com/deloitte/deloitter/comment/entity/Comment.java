package com.deloitte.deloitter.comment.entity;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {

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

    @ManyToOne
    @JoinColumn(
            name = "dwitt_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Dwitt dwitt;
}
