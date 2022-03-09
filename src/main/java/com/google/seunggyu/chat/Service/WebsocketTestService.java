package com.google.seunggyu.chat.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.seunggyu.chat.Model.ChatMessageDTO;
import com.google.seunggyu.chat.Model.ChattingRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class WebsocketTestService {


    public void SendMessage(WebSocketSession session,ChatMessageDTO message){

            try {
                session.sendMessage(new TextMessage(session.getId() + " : " + message.getMessage()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


