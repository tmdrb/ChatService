package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.TestChattingroom;
import com.google.seunggyu.chat.Model.TestDTO;
import com.google.seunggyu.chat.Model.TestUserDTO;
import com.google.seunggyu.chat.Model.User;

import java.util.HashMap;
import java.util.Optional;

public interface ChatService {

    public void chat(String content, User user);

    public void chat(String chatroomname,String content, TestUserDTO user);

    public Optional<String> seechat(String chatroomname);

    public String join(String chatroomname, TestUserDTO user);

    public String makeChatroom(String chatroomname);
}
