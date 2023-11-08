package com.postitters.postitters.posts.service;

import com.postitters.postitters.posts.entities.Users;
import com.postitters.postitters.posts.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserCatcherTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void allUsers() {
        UserRepo repoUser = mock(UserRepo.class);
        UserCatcher userCatcher = new UserCatcher(repoUser);
        List<Users> finalUsers = new ArrayList<>();
        Users users0 = new Users();
        Users users1 = new Users();

        users0.setArroba("@ArrobaZero");
        users1.setArroba("@ArrobaUm");

        finalUsers.add(users0);
        finalUsers.add(users1);

        when(repoUser.findAll()).thenReturn(finalUsers);

        assertEquals(UserCatcher.AllUsers(), finalUsers, "O retorno do repositório e o retorno do UserCatcher.findAll é diferente.");
    }

    @Test
    void getUserById() {

    }
}