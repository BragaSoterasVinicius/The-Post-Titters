package com.postitters.postitters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String interfaceCadastral(Model model){
        System.out.println("cadastra ae ");
        return "cadastro";

    }
}
