package com.deloitte.deloitter.user.entity;


import com.deloitte.deloitter.dwitt.entity.Dwitt;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String name;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Dwitt> dwitts;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "TutorialUser{" +
                "id=" + id +
                ", username='" + name + '\'' +
                '}';
    }

}
