package com.google.seunggyu.chat.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.seunggyu.chat.Model.TestChattingroom;
import com.google.seunggyu.chat.Model.TestDTO;
import com.google.seunggyu.chat.Model.TestUserDTO;
import com.google.seunggyu.chat.Model.User;
import com.google.seunggyu.chat.Repoistory.ChatRoomRepository;
import com.google.seunggyu.chat.Repoistory.ChatRoomUserRepository;
import com.google.seunggyu.chat.Repoistory.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceTest {


    @Autowired
    ChatRoomUserRepository chatRoomUserService;

    @Test
    public void chat() {


    }



}