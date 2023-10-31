package com.postitters.postitters.posts.repo;

import com.postitters.postitters.posts.entities.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PostRepo extends JpaRepository<Posts, Integer> {

        @Query(value = "SELECT * FROM Posts WHERE ARROBA = :userArroba", nativeQuery = true)
        List findPostsByArroba(String userArroba);

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO posts(ARROBA, TEXTCONTENT, IMAGECONTENT) VALUES (:Arroba, :textcontent, :url );", nativeQuery = true)
        void createPost(String Arroba, String textcontent, String url);

        @Transactional
        @Modifying
        @Query(value = "UPDATE posts SET TEXTCONTENT= :textcontent WHERE ID = :id", nativeQuery = true)
        void putPost(Integer id, String textcontent);

        @Transactional
        @Modifying
        @Query(value = "DELETE FROM posts WHERE ID= :id", nativeQuery = true)
        void deletePost(Integer id);

}
