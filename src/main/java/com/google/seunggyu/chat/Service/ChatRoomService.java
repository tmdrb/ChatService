package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.ChatRoomUser;
import com.google.seunggyu.chat.Model.ChattingRoom;
import com.google.seunggyu.chat.Model.ChattingRoomDTO;
import com.google.seunggyu.chat.Model.User;
import com.google.seunggyu.chat.Repoistory.ChatRoomRepository;
import com.google.seunggyu.chat.Repoistory.ChatRoomUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChatRoomService {
    private final Logger logger = LogManager.getLogger();

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    ChatRoomUserService chatRoomUserService;

    @Transactional
    public Boolean joinChatroom(String chatroomid,User tempuser){
        ChattingRoom tempchatroom = isChatroom(chatroomid);
        if(tempchatroom != null){
            if(chatRoomUserService.isChatRoomUser(chatroomid,tempuser.getId())){
                chatRoomUserService.saveChatroomuser(ChatRoomUser.builder()
                        .user(tempuser).chattingRoom(tempchatroom).build());
            }
            return true;

        }

        return false;
    }
    public ChattingRoom isChatroom(String chatroomid){

        ChattingRoom chattingRoom =  chatRoomRepository.findById(chatroomid).orElseGet(()->{
            return null;
        });
        return chattingRoom;
    }
    public ChattingRoom getChattingRoom(String chatroom_id){

        ChattingRoom chattingRoom = chatRoomRepository.findById(chatroom_id).orElseThrow();
        return chattingRoom;
    }


    public ChattingRoom makeChatroom(String chatname, User user){
        ChattingRoom temp = chatRoomRepository.save(ChattingRoom.builder()
                        .chatroomid(UUID.randomUUID().toString())
                        .chatroomname(chatname).build());

        if(temp != null){

            joinChatroom(temp.getChatroomid(),user);

        }
        return temp;

    }
}
