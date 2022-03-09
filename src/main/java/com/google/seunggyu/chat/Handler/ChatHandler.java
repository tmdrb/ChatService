package com.google.seunggyu.chat.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.seunggyu.chat.Model.*;
import com.google.seunggyu.chat.Service.*;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.sql.Timestamp;
import java.util.*;


@Component
public class ChatHandler implements WebSocketHandler {

    private Logger logger = LogManager.getLogger();
    private ObjectMapper mapper;
    private List<String> checklist;
    private HashMap<String, Set<WebSocketSession>> socketrooms = new HashMap();
    private User tempuser;

    @Autowired
    WebsocketTestService websocketTestService;

    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    UserService userService;

    @Autowired
    ChatDTOService chatDTOService;

    @Autowired
    ChatRoomUserService chatRoomUserService;

    public ChatHandler() {
        mapper = new ObjectMapper();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        tempuser = userService.getUser((String)session.getAttributes().get("userid"));
        checklist = new ArrayList<>();
        logger.info(session + "입장");
        System.out.println(tempuser);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payload = message.getPayload().toString();
        ChatMessageDTO chatmessage = mapper.readValue(payload,ChatMessageDTO.class);

        logger.info(chatmessage);

        switch (chatmessage.getType()){

            case 0:
                ChattingRoom chatroom = chatRoomService.makeChatroom(chatmessage.getMessage(),tempuser);
                if(chatroom != null) {
                    logger.info(chatmessage.getMessage()+"방 생성되었습니다.");
                    Set<WebSocketSession> sessions = new HashSet<>();
                    sessions.add(session);
                    socketrooms.put(chatroom.getChatroomid(),sessions);
                    checklist.add(chatmessage.getRoomid());
                }
                else{
                    logger.info("방 생성 실패");

                }
                break;
            case 1:

                if(chatRoomService.joinChatroom(chatmessage.getRoomid(),tempuser)){
                    try{
                    socketrooms.get(chatmessage.getRoomid()).add(session);
                    }catch (NullPointerException e){
                        Set<WebSocketSession> sessions = new HashSet<>();
                        sessions.add(session);
                        socketrooms.put(chatmessage.getRoomid(),sessions);
                    }
                    checklist.add(chatmessage.getRoomid());
                    logger.info(tempuser.getName() + "님 입장");
                }else{
                    logger.info("입장실패");
                }

                break;
            case 2:

                List<ChatRoomUser> chatRoomUsers = chatRoomUserService.getChatroomusers(chatmessage.getRoomid());
                List<String> usercheck = new ArrayList<>();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ChatDTO insertdto = ChatDTO.builder()
                        .chattingRoom(chatRoomUsers.get(0).getChattingRoom())
                        .content(chatmessage.getMessage())
                        .userwho(userService.getUser(chatmessage.getSender()))
                        .timestamp(timestamp)
                        .build();


                if(chatRoomUsers != null) {
                    chatDTOService.insert(insertdto);
                    for (ChatRoomUser chatroomuser:chatRoomUsers) {
                        usercheck.add(chatroomuser.getUser().getId());
                    }
                }

                for(WebSocketSession childsession: socketrooms.get(chatmessage.getRoomid())){
                    logger.info(childsession);
                    websocketTestService.SendMessage(childsession,chatmessage);
                }

                break;
        }

       /* if ( == 0 ){

            if(websocketTestService.EnterChattingRoom(session,chatmessage))
                logger.info(session.getId()+"님 채팅방에 입장했습니다.");
            else
                logger.info("채팅방이 존재하지 않습니다.");
        }
        else if (chatmessage.getType() == 1) {
            websocketTestService.SendMessage(session,chatmessage);
        }
        else if*/
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        tempuser = null;

        logger.info(session + "만료");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
