package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
//    @ResponseBody
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        Post newPost2 = new Post(2, "I'm sleepy today", "I think I might go to bed early tonight.");
        Post newPost3 = new Post(3, "I bought that boat", "LOL no I didn't that's dumb.");
        posts.add(newPost2);
        posts.add(newPost3);
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String postID(@PathVariable int id, Model model) {
        Post newPost = new Post(1, "I'm Thinking of Buying a Boat", "So I'm thinking I might buy a boat.");
        String title = newPost.getTitle();
        String body = newPost.getBody();
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "posts/show";
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
