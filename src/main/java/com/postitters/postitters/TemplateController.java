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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Controller
public class TemplateController {

    @Autowired
    private final PostCatcher postCatcher;
    private final PostRepo postRepo;
    private final MemeController memeController;

    private final LoginController loginController;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/pics";
    @Autowired
    public TemplateController(PostCatcher postCatcher, PostRepo postRepo, MemeController memeController, LoginController loginController) {
        this.postCatcher = postCatcher;
        this.postRepo = postRepo;
        this.memeController = memeController;
        this.loginController = loginController;
    }


    @GetMapping("/home")
    public String getMainPosts(Model model) throws IOException, ParseException {
        String username = loginController.actualUser.getNick();
        model.addAttribute("Usernick", username);
        List<Posts> posts = postCatcher.AllPosts();
        Collections.reverse(posts);
        model.addAttribute("listposts", posts);

        String memes = memeController.getMemes();
        System.out.println(memes);
        model.addAttribute("redditposts",memes);
        return "index";
    }

    @PostMapping("/postin")
    public String poster(@ModelAttribute("inputAModel")
                             InputAModel formModel,
                         Model model, @RequestParam("image") MultipartFile file)
                        throws IOException, ParseException {
        String imgUrl = null;
        System.out.println("la vai ele");
        model.addAttribute("formModel", new InputAModel());
        String textInput = formModel.getTextInput();

        System.out.println("Oi meu nome eh"+file);
        System.out.println("ja chegamos aqui");



            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());

        if(file.getSize()>0) {System.out.println( "FUCKKK");
            imgUrl = file.getOriginalFilename();
            fileNames.append(file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            System.out.println("mitada violenta"+ imgUrl);
            model.addAttribute("msg", "Uploaded images " + fileNames.toString());
        }else{
            System.out.println("ih la ele");
        }

        postRepo.createPost(loginController.actualUser.getArroba(), textInput, imgUrl);
        getMainPosts(model);
        System.out.println("mitada muito violenta fin");
        return "redirect:/home";
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
