package com.google.seunggyu.chat.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@ToString
@Builder
public class TestChattingroom {

    String chatroomname;

    ArrayList<TestUserDTO> users;

    ArrayList<TestDTO> chatlist;

}
