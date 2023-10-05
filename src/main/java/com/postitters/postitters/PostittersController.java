package com.postitters.postitters;

import com.postitters.postitters.funcs.Posts;
import com.postitters.postitters.service.PostCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostittersController {
    private final PostCatcher postCatcher;

    @Autowired
    public PostittersController(PostCatcher postCatcher) {
        this.postCatcher = postCatcher;
    }

    @GetMapping
    public List<Posts> getAllPosts(){
        return PostCatcher.AllPosts();
    }
}
