package com.postitters.postitters.posts.repo;

import com.postitters.postitters.posts.entities.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface UserRepo  extends JpaRepository<Users, String> {
    @Modifying
    @Query(value="INSERT INTO users(ARROBA, NICK, SNH) VALUES (:newArroba, :newNick, :newPass);", nativeQuery = true)
    void CreateUser(String newArroba, String newNick, String newPass);

    @Query(value = "SELECT SNH FROM users WHERE ARROBA = :userArroba", nativeQuery = true)
    String findLogByArroba(String userArroba);

    @Query(value = "SELECT NICK FROM users WHERE ARROBA = :userArroba", nativeQuery = true)
    String findNickByArroba(String userArroba);
}
