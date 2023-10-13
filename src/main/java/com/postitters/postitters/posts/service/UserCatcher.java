package com.postitters.postitters.posts.service;

import com.postitters.postitters.posts.funcs.Posts;
import com.postitters.postitters.posts.repo.PostRepo;
import com.postitters.postitters.posts.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postitters.postitters.posts.funcs.Users;

import java.util.List;
@Service
public class UserCatcher {
    private static UserRepo repo = null;

    @Autowired
    public UserCatcher(UserRepo repo) {
        this.repo = repo;
    }

    public static List<Users> AllUsers(){
        return repo.findAll();
    }

    public static Users getUserById(String arroba){
        return repo.findById(arroba).orElse(null);
    }

}
