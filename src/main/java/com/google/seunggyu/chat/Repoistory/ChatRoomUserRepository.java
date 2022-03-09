package com.google.seunggyu.chat.Repoistory;

import com.google.seunggyu.chat.Model.ChatRoomUser;
import com.google.seunggyu.chat.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomUserRepository extends JpaRepository<ChatRoomUser,Long> {

    List<ChatRoomUser> findByChattingRoom_chatroomid(String chatroom_id);
    Optional<ChatRoomUser> findByChattingRoom_chatroomidAndUser_id(String chatroom_id, String user_id);
}
