package com.google.seunggyu.chat.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
@NoArgsConstructor
public class TestDTO {

    String Content;
    TestUserDTO userDTO;

}
