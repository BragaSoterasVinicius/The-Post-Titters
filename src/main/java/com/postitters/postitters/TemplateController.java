package com.postitters.postitters;

import com.postitters.postitters.posts.funcs.InputAModel;
import com.postitters.postitters.posts.funcs.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import org.apache.juli.logging.Log;
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

        postRepo.createPost("@primeiro", textInput);
        return "index";
    }
    @GetMapping ("/alterin")
    public String putter(@ModelAttribute("inputAModel")InputAModel formModel, Model model){
        model.addAttribute("formGetModel", new InputAModel());

        String textInputPut = formModel.getTextInputPut();
        Integer intInput2 = formModel.getIntInput2();
        System.out.println(intInput2);System.out.println(textInputPut);
        postRepo.putPost(intInput2, textInputPut);
        return "index";
    }
    @GetMapping ("/deletin")
    public String deleter(@ModelAttribute("inputAModel")InputAModel formModel, Model model){
        model.addAttribute("formDeleteModel", new InputAModel());

        Integer intInput = formModel.getIntInput();
        System.out.println(intInput);
        postRepo.deletePost(intInput);
        return "index";
    }
}
