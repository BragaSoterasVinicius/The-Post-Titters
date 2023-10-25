package com.postitters.postitters;

import com.postitters.postitters.posts.entities.Users;
import com.postitters.postitters.posts.repo.UserRepo;
import com.postitters.postitters.posts.service.PasswordVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    public Users actualUser = new Users();

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final PasswordVerifier senTest;
    public LoginController(UserRepo userRepo, PasswordVerifier senTest) {
        this.userRepo = userRepo;
        this.senTest = senTest;
    }
    @GetMapping("/login")
    public String pimbas(Model model, @ModelAttribute("Users") Users userCadastro){
        return "login";

    }
    @GetMapping("/loggers")
    public String interfaceCadastral(Model model, @ModelAttribute("Users") Users userCadastro){
        model.addAttribute("loginModel", new Users());
        String nick = userCadastro.getNick();
        String arroba = userCadastro.getArroba();
        String senha = userCadastro.getSenha();
        System.out.println("verifica ae ");
        System.out.println(nick + arroba+ senha);
        if(senTest.passwordVerifier(arroba, senha)){
            actualUser.setArroba(arroba);
            actualUser.setNick(nick);

            System.out.println("boa bola!");
        }
        return "redirect:/home";

    }
}
