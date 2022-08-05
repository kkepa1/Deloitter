package com.deloitte.deloitter.comment.entity;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "dwitt_id",referencedColumnName = "id", nullable = false)
    private Dwitt dwitt;

    public Comment() {
    }

    public Comment(String content, User user, Dwitt dwitt) {
        this.content = content;
        this.user = user;
        this.dwitt = dwitt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}
