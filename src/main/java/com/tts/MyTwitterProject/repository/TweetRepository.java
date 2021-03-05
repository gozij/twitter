package com.tts.MyTwitterProject.repository;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.MyTwitterProject.model.Tweet;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAllByOrderByCreatedAtDesc();
    List<Tweet> findAllByUserOrderByCreatedAtDesc(User user);
    List<Tweet> findAllByUserInOrderByCreatedAtDesc(List<User> users);
    
    List<Tweet> findByTags_phraseOrderByCreatedAtDesc(String tag);
}


