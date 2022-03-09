package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.User;
import com.google.seunggyu.chat.Repoistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String id){


        User user = userRepository.findById(id).orElseThrow();

        return user;
    }
}