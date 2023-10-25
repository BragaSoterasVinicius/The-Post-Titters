package com.postitters.postitters.posts.service;

import com.postitters.postitters.posts.entities.Users;
import com.postitters.postitters.posts.repo.PostRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postitters.postitters.posts.repo.UserRepo;

@Service
public class PasswordVerifier {

    private static UserRepo repo = null;

    @Autowired
    public PasswordVerifier(UserRepo repo) {
        this.repo = repo;
    }
    public boolean passwordVerifier(String arroba, String pasword){

        String senha = repo.findLogByArroba(arroba);
        System.out.println("senha sendo verificada...");
        if(senha.equals(pasword)){
            return true;
        } else{
            System.out.println(senha);
            System.out.println(pasword);
            return false;
        }

    }
}
