package com.google.seunggyu.chat.Service;

import com.google.seunggyu.chat.Model.TestChattingroom;
import com.google.seunggyu.chat.Model.TestDTO;
import com.google.seunggyu.chat.Model.TestUserDTO;
import com.google.seunggyu.chat.Model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceTest {


    @Test
    public void chat() {

        Map<String,String> map = new HashMap();

        map.put("l","eeseunggyu");
        map.put("l2","eeseunggyu");
        map.put("l3","eeseunggyu");

        System.out.println(map.entrySet().stream().map(x->String.format("%s -> (%s)",x.getKey()))
                .collect(Collectors.joining(",")));

    }



}