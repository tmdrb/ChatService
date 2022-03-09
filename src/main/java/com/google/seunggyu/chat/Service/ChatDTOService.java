package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.ChatDTO;
import com.google.seunggyu.chat.Repoistory.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatDTOService {

    @Autowired
    ChatRepository chatRepository;

    public ChatDTO insert(ChatDTO insertdto){
        return chatRepository.save(insertdto);
    }
}
