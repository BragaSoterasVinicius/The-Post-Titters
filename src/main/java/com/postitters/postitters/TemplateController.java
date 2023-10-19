package com.postitters.postitters;

import com.postitters.postitters.posts.MemeController;
import com.postitters.postitters.posts.entities.InputAModel;
import com.postitters.postitters.posts.entities.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class TemplateController {

    @Autowired
    private final PostCatcher postCatcher;
    private final PostRepo postRepo;
    private final MemeController memeController;
    @Autowired
    public TemplateController(PostCatcher postCatcher, PostRepo postRepo, MemeController memeController) {
        this.postCatcher = postCatcher;
        this.postRepo = postRepo;
        this.memeController = memeController;
    }

    @GetMapping
    public String getMainPosts(Model model) throws IOException, ParseException {
        List<Posts> posts = postCatcher.AllPosts();
        Collections.reverse(posts);
        model.addAttribute("listposts", posts);

        String memes = memeController.getMemes();
        System.out.println(memes);
        model.addAttribute("redditposts",memes);
        return "index";
    }

    @PostMapping("/postin")
    public String poster(@ModelAttribute("inputAModel") InputAModel formModel, Model model) throws IOException, ParseException {
        model.addAttribute("formModel", new InputAModel());
        String textInput = formModel.getTextInput();

        postRepo.createPost("@primeiro", textInput);
        getMainPosts(model);
        return "index";
    }

    @GetMapping("/alterin")
    public String putter(@ModelAttribute("inputAModel") InputAModel formModel, Model model) throws IOException, ParseException {
        model.addAttribute("formGetModel", new InputAModel());

        String textInputPut = formModel.getTextInputPut();
        Integer intInput2 = formModel.getIntInput2();
        System.out.println(intInput2);
        System.out.println(textInputPut);
        postRepo.putPost(intInput2, textInputPut);
        getMainPosts(model);
        return "index";
    }

    @GetMapping("/deletin")
    public String deleter(@ModelAttribute("inputAModel") InputAModel formModel, Model model) throws IOException, ParseException {
        model.addAttribute("formDeleteModel", new InputAModel());

        Integer intInput = formModel.getIntInput();
        System.out.println(intInput);
        postRepo.deletePost(intInput);
        getMainPosts(model);
        return "index";
    }

    @RequestMapping("/searchPage")
    public String searches(@ModelAttribute("inputAModel") InputAModel formModel, Model model) {
        return "searchPage";
    }

}
