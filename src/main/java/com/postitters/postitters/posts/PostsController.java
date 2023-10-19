package com.postitters.postitters.posts;

import com.postitters.postitters.posts.entities.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostRepo postRepo;
    private final PostCatcher postCatcher;

    @Autowired
    public PostsController(PostRepo postRepo, PostCatcher postCatcher) {
        this.postRepo = postRepo;
        this.postCatcher = postCatcher;
    }

   @GetMapping
    public List<Posts> getAllPosts(){
        return postCatcher.AllPosts();
    }

    @GetMapping("/{id}")
    public Posts getAPost(@PathVariable Integer id){
        return postCatcher.getPostById(id);
    }

    @GetMapping ("delete/{ide}")
    public void delete(@PathVariable Integer ide){
        postRepo.deletePost(ide);
    }

    @GetMapping("/byArroba/{arroba}")
    public List<Posts> getByArromba(@PathVariable String arroba){
        return postRepo.findPostsByArroba(arroba);
    }

    @GetMapping("/postin")
    public void poster(){
        postRepo.createPost("@primeiro", "nossa mano como eu amo sneakers meoo.U+1F600");
    }
}
