package com.codeup.springblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "This is where you'll see posts";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postID(@PathVariable int id) {
        return "This is where you'll see a post by ID";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "This is where you'll see the create post form";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String post() {
        return "This is where you'll create a new post";
    }
}
