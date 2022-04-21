package com.codeup.springblog;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;
    @OneToOne
    private User user;


    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;

    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;

    }

    public Post() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }

}
