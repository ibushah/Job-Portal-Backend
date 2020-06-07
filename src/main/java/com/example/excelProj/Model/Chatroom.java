package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Chatroom {


    @Id
    @GeneratedValue
    Long id;



    @JsonIgnore
    @ManyToOne
    User user1;

    @JsonIgnore
    @ManyToOne
    User user2;

    @OneToMany(mappedBy = "chatroom")
    List<Chat> chats;

    public Chatroom( User user1, User user2) {

        this.user1 = user1;
        this.user2 = user2;
    }


    public Chatroom() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
