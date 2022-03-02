package com.google.seunggyu.chat.Model;

import lombok.*;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TestChattingroom {

    String chatroomname;

    ArrayList<TestUserDTO> users;

    ArrayList<TestDTO> chatlist;

}
