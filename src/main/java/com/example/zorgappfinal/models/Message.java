package com.example.zorgappfinal.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image attachment;

    @ManyToMany(mappedBy = "messages")
    @OnDelete(action = CASCADE)
    List<Account> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }

    public Image getAttachment(){
        return attachment;
    }


    public String setTitle( String title){
        this.title = title;
        return title;
    }
    public String setBody( String body){
        this.body = body;
        return body;
    }

    public Image setAttachment( Image attachment){
        this.attachment = attachment;
        return attachment;
    }

    public List<Account> getAccounts() {
        return users;
    }
    public void setAccounts( List<Account> accounts){
        accounts = users;

    }

    public void addUser(Account user) {
        this.users.add(user);
    }
}
