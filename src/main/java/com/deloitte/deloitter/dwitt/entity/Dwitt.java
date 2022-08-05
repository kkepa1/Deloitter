package com.deloitte.deloitter.dwitt.entity;

import com.deloitte.deloitter.comment.entity.Comment;
import com.deloitte.deloitter.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "dwitt")
    private List<Comment> comments = new ArrayList<>();
}
