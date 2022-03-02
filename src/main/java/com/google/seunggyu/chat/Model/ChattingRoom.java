package com.google.seunggyu.chat.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChattingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatroomid;

    @Column(nullable = false,length = 30)
    private String chatroomname;

    @OneToMany(mappedBy = "chattingRoom" , fetch = FetchType.EAGER)
    private List<ChatDTO> chatDTOS;
}
