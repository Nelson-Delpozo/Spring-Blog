package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post getById(long id);
    List<Post> getByUser(User user);

}
