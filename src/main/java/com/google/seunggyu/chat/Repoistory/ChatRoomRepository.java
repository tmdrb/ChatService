package com.google.seunggyu.chat.Repoistory;

import com.google.seunggyu.chat.Model.ChattingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChattingRoom,String> {
}
