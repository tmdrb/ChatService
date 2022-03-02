package com.google.seunggyu.chat.Controller;

import com.google.seunggyu.chat.Model.ChatDTO;
import com.google.seunggyu.chat.Model.ChattingRoom;
import com.google.seunggyu.chat.Model.TestUserDTO;
import com.google.seunggyu.chat.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController("/chat")
public class ChattingController {

    @Autowired
    TestService testService;

    @GetMapping("/Mymain")
    public ChattingRoom getMyChattingRoom(){

        return null;
    }

    @GetMapping("/{chat_id}")
    public ChatDTO getChatDTO(@PathVariable("chat_id") String chat_id){

        return null;
    }



    @GetMapping("/{chat_id}/send")
    public void send(@PathVariable("chat_id") String chat_id, @RequestBody String content, @RequestBody TestUserDTO user){
        testService.chat(chat_id,content,user);
    }

    @GetMapping("/{chat_id}")
    public String getChatMap(@PathVariable("chat_id") String chat_id){

        return testService.seechat(chat_id);
    }
    @PostMapping("/{chat_id}/send")
    public ChatDTO send(@PathVariable("chat_id") String chat_id, @RequestBody ChatDTO chatdto){

        return null;
    }

}
