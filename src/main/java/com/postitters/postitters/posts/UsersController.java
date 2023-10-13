package com.postitters.postitters.posts;

import com.postitters.postitters.posts.funcs.Users;
import com.postitters.postitters.posts.repo.UserRepo;
import com.postitters.postitters.posts.service.PostCatcher;
import com.postitters.postitters.posts.service.UserCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserCatcher userCatcher;
    private final UserRepo userRepo;
    @Autowired
    public UsersController(PostCatcher postCatcher, UserCatcher userCatcher, UserRepo userRepo) {
        this.userCatcher = userCatcher;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userCatcher.AllUsers();
    }

    @GetMapping("/{id}")
    public Users getAPost(@PathVariable String id){
        return UserCatcher.getUserById(id);
    }

    @GetMapping("/create")
    public Users userMkr(/*String newArroba, String newNick, String newPass*/){
       // userRepo.CreateUser(newArroba,newNick,newPass);
        userRepo.CreateUser("@primeiro","Sneakers", "Segredinhos");
        return null;
    }
}
