package com.google.seunggyu.chat.Model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
public class ChattingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatroomid;

    @Column(nullable = false,length = 30)
    private String chatroomname;

    @OneToMany(mappedBy = "ChattingRoom",fetch = FetchType.EAGER)
    private List<ChatDTO> chatDTOS;
}
