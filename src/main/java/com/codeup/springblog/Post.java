package com.codeup.springblog;

import org.hibernate.mapping.ToOne;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Value("${file-upload-path}")
    private String uploadPath;

    public Post() {
    }

    public Post(long id, String title, String body, User user, String uploadPath) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.uploadPath = uploadPath;
    }

    public Post(String title, String body, User user, String uploadPath) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.uploadPath = uploadPath;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
