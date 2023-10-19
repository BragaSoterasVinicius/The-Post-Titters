package com.postitters.postitters.posts.service;

import com.postitters.postitters.posts.entities.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostCatcher {
    private static PostRepo repo = null;

    @Autowired
    public PostCatcher(PostRepo repo) {
        this.repo = repo;
    }

    public static List<Posts> AllPosts(){
        return repo.findAll();
    }

    public Posts getPostById(Integer id){
        return repo.findById(id).orElse(null);
    }


}
