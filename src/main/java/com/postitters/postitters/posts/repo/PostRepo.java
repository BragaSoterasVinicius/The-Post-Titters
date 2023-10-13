package com.postitters.postitters.posts.repo;

import com.postitters.postitters.posts.funcs.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Posts, Integer> {

        @Query(value="SELECT * FROM Posts WHERE ARROBA = :userArroba", nativeQuery = true)
        List findPostsByArroba(String userArroba);
        @Transactional
        @Modifying
        @Query(value="INSERT INTO posts(ARROBA, TEXTCONTENT) VALUES (:Arroba, :textcontent);", nativeQuery = true)
        void CreatePost(String Arroba, String textcontent);

}
