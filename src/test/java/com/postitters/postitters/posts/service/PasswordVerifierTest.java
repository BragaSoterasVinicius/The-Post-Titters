package com.postitters.postitters.posts.service;

import com.postitters.postitters.posts.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PasswordVerifierTest {
    String inputArroba = "@Teste";

    String repoSenha = "teste";

    @ParameterizedTest
    @ValueSource(strings = {"Teste"})
    public void passwordVerifierTest(String senhaTeste){

        UserRepo userRepo = mock(UserRepo.class);
        PasswordVerifier passwordVerifier = new PasswordVerifier(userRepo);
        userRepo.CreateUser(inputArroba, "nick" ,repoSenha);

        when(userRepo.findLogByArroba(inputArroba)).thenReturn(senhaTeste);

        assertEquals(true,
                passwordVerifier.passwordVerifier(inputArroba,senhaTeste),
                "Erro na verificação de senha");
    }
}