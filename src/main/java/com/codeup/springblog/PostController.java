package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

    @GetMapping("/users/{id}")
//    @ResponseBody
    public String userID(@PathVariable long id, Model model) {
        model.addAttribute("users", userDAO.findAllById(Collections.singleton(id)));
//        model.addAttribute("posts", postDao.getByUser(userDAO.getUserById(id)));
        return "users";
    }

    @GetMapping("/users")
//    @ResponseBody
    public String users(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "users";
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
        long id = (long) (Math.floor(Math.random() * 3) + 1);//this just assigns a random user id to a post for fun that's all...will replace later.
        newPost.setUser(userDAO.getUserById(id));
        postDao.save(newPost);
        return "redirect:/posts";
    }
}
