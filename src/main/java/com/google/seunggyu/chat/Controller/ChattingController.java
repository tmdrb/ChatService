package com.google.seunggyu.chat.Controller;

import com.google.seunggyu.chat.Model.*;
import com.google.seunggyu.chat.Repoistory.ChatRoomUserRepository;
import com.google.seunggyu.chat.Repoistory.UserRepository;
import com.google.seunggyu.chat.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ChattingController {

    @Autowired
    private WebsocketTestService websocketTestService;

    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    ChatRoomUserService chatRoomUserService;

    @Autowired
    ChatRoomUserRepository chatRoomUserRepository;

    @Autowired
    UserService userService;




    @MessageMapping("/test")
    @SendTo("/sub/chat/1")
    public String enter(ChatMessageDTO chatMessageDTO){

        chatMessageDTO.setMessage(chatMessageDTO.getSender() + "님 입장");
        return "hihoi";
    }

    @PostMapping("/makechat")
    public String Mkchat(@RequestParam("chatname") String name){
        chatRoomService.makeChatroom(name,userService.getUser("tmdrb"));

        return name + "방 개설완료";
    }

    @PostMapping("/joinchat")
    public String JoinChat(@RequestParam("chatroom_id") String chatroom_id){

        return "dl님 참여완료";
    }

    @GetMapping("/seechat")
    public String SeeChattingroom(){
        System.out.println(chatRoomUserRepository.findByChattingRoom_chatroomid("a659df9e-8e2c-4f72-8bd0-2bbb039259da").toString());
        return "";
    }
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
