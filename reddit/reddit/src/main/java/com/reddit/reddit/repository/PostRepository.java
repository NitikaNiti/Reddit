package com.reddit.reddit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddit.reddit.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
