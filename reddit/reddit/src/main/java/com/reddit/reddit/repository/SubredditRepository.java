package com.reddit.reddit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddit.reddit.model.Subreddit;
@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {

}
