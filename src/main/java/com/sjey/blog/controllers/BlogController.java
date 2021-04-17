package com.sjey.blog.controllers;

import com.sjey.blog.entities.Post;
import com.sjey.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping(value="/posts")
    public List<Post> posts() {
        return postService.getAllPosts();
    }

    @PostMapping(value="/post")
    public String publishPost(@RequestBody Post post){
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        postService.insert(post);
        return "Post was published";
    }

    @GetMapping(value="/the_post/{id}")
    public Post getPostById(@PathVariable Long id) throws Exception {
        return postService.getPost(id);
    }
}
