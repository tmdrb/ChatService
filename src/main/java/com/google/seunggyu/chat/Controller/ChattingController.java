package com.google.seunggyu.chat.Controller;

import com.google.seunggyu.chat.Model.*;
import com.google.seunggyu.chat.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChattingController {



    //Rest API를 이용한 채팅
    /*

    @Autowired
    TestService testService;

    @GetMapping("/Mymain")
    public HashMap getMyChattingRoom(){

        return testService.getChat();
    }

    @GetMapping("/makechatroom/{chat_id}")
    public String makechatroom(@PathVariable("chat_id")String chat_id){

        return testService.makeChatroom(chat_id);
    }



    @PostMapping("/{chat_id}/send")
    public void send(@PathVariable("chat_id") String chat_id, @RequestBody TestDTO testDTO){

        testService.chat(chat_id,testDTO.getContent(),testDTO.getUserDTO());
    }

    @GetMapping("/{chat_id}")
    public Optional<String> getChatMap(@PathVariable("chat_id") String chat_id){

        return testService.seechat(chat_id);
    }
*/

}
