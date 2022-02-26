package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.TestChattingroom;
import com.google.seunggyu.chat.Model.TestDTO;
import com.google.seunggyu.chat.Model.TestUserDTO;
import com.google.seunggyu.chat.Model.User;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TestService implements ChatService {

    TestDTO chat = new TestDTO();

    TestUserDTO user = new TestUserDTO();


    HashMap<String,TestChattingroom> chatmap = new HashMap<>();


    @Override
    public void chat(String content, User user) {

    }

    @Override
    public void chat(String chatroomname,String content, TestUserDTO user) {
        chat.setContent(content);
        chat.setUserDTO(user);
        chatmap.get(chatroomname).getChatlist().add(chat);

    }

    @Override
    public String seechat(String chatroomname) {
        return chatmap.get(chatroomname).getChatlist().toString();
    }

    @Override
    public String join(String chatroomname, TestUserDTO user) {


        chatmap.get(chatroomname).getUsers().add(user);

        return user.getName() + "이 참여했습니다.";
    }

    @Override
    public String makeChatroom(String chatroomname) {
        TestChattingroom chattingroom = TestChattingroom.builder()
                .chatroomname(chatroomname)
                .chatlist(new ArrayList<>())
                .users(new ArrayList<>())
                .build();

        chatmap.put(chatroomname,chattingroom);
        return chatroomname + "이 개설되었습니다.";
    }
}
