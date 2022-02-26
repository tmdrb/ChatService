package com.google.seunggyu.chat.Controller;

import com.google.seunggyu.chat.Model.ChatDTO;
import com.google.seunggyu.chat.Model.ChattingRoom;
import org.springframework.web.bind.annotation.*;

@RestController("/chat")
public class ChattingController {



    @GetMapping("/Mymain")
    public ChattingRoom getMyChattingRoom(){

        return null;
    }

    @GetMapping("/{chat_id}")
    public ChatDTO getChatDTO(@PathVariable("chat_id") String chat_id){

        return null;
    }

    @PostMapping("/{chat_id}/send")
    public ChatDTO send(@PathVariable("chat_id") String chat_id, @RequestBody ChatDTO chatdto){

        return null;
    }

}
