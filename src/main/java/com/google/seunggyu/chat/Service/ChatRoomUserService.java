package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.ChatRoomUser;
import com.google.seunggyu.chat.Model.ChattingRoom;
import com.google.seunggyu.chat.Model.User;
import com.google.seunggyu.chat.Repoistory.ChatRoomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomUserService {

    @Autowired
    ChatRoomUserRepository chatRoomUserRepository;

    public ChatRoomUser saveChatroomuser(ChatRoomUser chatRoomUser){

        return chatRoomUserRepository.save(chatRoomUser);
    }

    public List<ChatRoomUser> getChatroomusers(String chatroomid){

        return chatRoomUserRepository.findByChattingRoom_chatroomid(chatroomid);
    }

    public Boolean isChatRoomUser(String chatroomid,String userid){
        ChatRoomUser temp = chatRoomUserRepository.findByChattingRoom_chatroomidAndUser_id(chatroomid,userid).orElseGet(()->{
            return null;
        });
        if(temp != null)
            return false;
        return true;
    }
}
