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
//        List<Post> posts = new ArrayList<>();
//        Post newPost2 = new Post(2, "I'm sleepy today", "I think I might go to bed early tonight.");
//        Post newPost3 = new Post(3, "I bought that boat", "LOL no I didn't that's dumb.");
//        posts.add(newPost2);
//        posts.add(newPost3);

        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String postID(@PathVariable long id, Model model) {
//        Post newPost = new Post(1, "I'm Thinking of Buying a Boat", "So I'm thinking I might buy a boat.");
//        String title = newPost.getTitle();
//        String body = newPost.getBody();
//        model.addAttribute("title", title);
//        model.addAttribute("body", body);
        model.addAttribute("posts", postDao.findAllById(Collections.singleton(id)));
        return "posts/show";
    }

    @GetMapping("/posts/create")
//    @ResponseBody
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
//    @ResponseBody
    public String post(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post newPost = new Post();
//        User user = userDAO.getUserById(1L);
        newPost.setTitle(title);
        newPost.setBody(body);
//        newPost.setUser(user);

//        newPost.setUser(userDAO.getUserById(1));
        postDao.save(newPost);
//        model.addAttribute("posts", postDao.findAll());
//        model.addAttribute("body", body);
        return "redirect:/posts";
    }

}
