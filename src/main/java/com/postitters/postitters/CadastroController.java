package com.postitters.postitters;

import com.postitters.postitters.posts.entities.Users;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private final UserRepo userRepo;

    public CadastroController( UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping("/cadastro")
    public String pimbas(Model model, @ModelAttribute("Users") Users userCadastro){
        return "cadastro";

    }
    @GetMapping("/cadastrar")
    public String interfaceCadastral(Model model, @ModelAttribute("Users") Users userCadastro){
        model.addAttribute("cadastroModel", new Users());
        String nick = userCadastro.getNick();
        String arroba = "@"+userCadastro.getArroba();
        String senha = userCadastro.getSenha();
        System.out.println("cadastra ae ");
        System.out.println(nick + arroba+ senha);
        userRepo.CreateUser(arroba,nick,senha);
        return "redirect:/home";

    }
}
