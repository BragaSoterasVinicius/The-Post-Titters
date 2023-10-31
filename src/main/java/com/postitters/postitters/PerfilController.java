package com.postitters.postitters;

import com.postitters.postitters.posts.MemeController;
import com.postitters.postitters.posts.entities.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PerfilController {

    @Autowired
    private final PostCatcher postCatcher;

    @Autowired
    private final PostRepo repo;

    private final MemeController memeController;

    public PerfilController(PostCatcher postCatcher, PostRepo repo, MemeController memeController) {
        this.postCatcher = postCatcher;
        this.repo = repo;
        this.memeController = memeController;
    }

    @GetMapping("/user/{arroba}")
    public String getUserPosts(@PathVariable String arroba, Model model) throws IOException, ParseException {

        List<Posts> posts = repo.findPostsByArroba(arroba);
        Collections.reverse(posts);
        System.out.println(posts.get(1));

        model.addAttribute("listposts", posts);



        String memes = memeController.getMemes();
        System.out.println(memes);
        model.addAttribute("redditposts",memes);
        return "perfil";

    }
}
