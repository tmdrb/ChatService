package com.google.seunggyu.chat.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Builder
public class ChattingRoomDTO {

    private String roomid;
    private String name;
    private Set<WebSocketSession> sessions;
    private List<ChatMessageDTO> chatMessageDTOList;
}
