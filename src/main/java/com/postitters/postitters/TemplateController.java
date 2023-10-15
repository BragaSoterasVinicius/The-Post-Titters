package com.postitters.postitters;

import com.postitters.postitters.posts.funcs.InputAModel;
import com.postitters.postitters.posts.funcs.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TemplateController {

    @Autowired
    private final PostCatcher postCatcher;
    private final PostRepo postRepo;
    @Autowired
    public TemplateController(PostCatcher postCatcher, PostRepo postRepo) {
        this.postCatcher = postCatcher;
        this.postRepo = postRepo;
    }

    @GetMapping
    public String getMainPosts(Model model) {
        List<Posts> posts = postCatcher.AllPosts();
        model.addAttribute("listposts", posts);
        System.out.println(posts);
        return "index";
    }

    @PostMapping ("/postin")
    public String poster(@ModelAttribute("inputAModel")InputAModel formModel, Model model){
        model.addAttribute("formModel", new InputAModel());
        String textInput = formModel.getTextInput();

        postRepo.CreatePost("@primeiro", textInput);
        return "index";
    }
}
