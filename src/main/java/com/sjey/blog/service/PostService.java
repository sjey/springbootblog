package com.sjey.blog.service;

import com.sjey.blog.entities.Post;
import com.sjey.blog.error.PostNotFoundException;
import com.sjey.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }

    public Post getPost(Long id) throws Exception {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    //public Post return404(){
    //    return postRepository.
    //}

    // public List<Post> findByUser(User user){
   //     return postRepository.findByCreatorId(user.getId());
   // }
}
