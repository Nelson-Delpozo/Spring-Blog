package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDAO;

    public PostController(PostRepository postDao, UserRepository userDAO) {
        this.postDao = postDao;
        this.userDAO = userDAO;
    }

    @GetMapping("/posts")
//    @ResponseBody
    public String posts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String postID(@PathVariable long id, Model model) {
        model.addAttribute("posts", postDao.findAllById(Collections.singleton(id)));
        return "posts/show";
    }

    @GetMapping("/posts/create")
//    @ResponseBody
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("user", new User());
        return "posts/create";
    }

    @PostMapping("/posts/create")
//    @ResponseBody
    public String post(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        newPost.setUser(userDAO.getUserById(1));
        String username = userDAO.getUserById(1).getUsername();
        postDao.save(newPost);
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("username", username);
        return "posts/index";
    }
}
