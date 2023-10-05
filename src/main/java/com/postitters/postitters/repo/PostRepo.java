package com.postitters.postitters.repo;

import com.postitters.postitters.funcs.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Posts, Integer> {

}
