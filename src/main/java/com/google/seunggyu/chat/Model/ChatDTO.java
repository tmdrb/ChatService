package com.google.seunggyu.chat.Model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;


@Data
@Builder
@Entity
public class ChatDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatid;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userid")
    private User userwho;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="chatroomid")
    private ChattingRoom chattingRoom;

    @CreationTimestamp
    private Timestamp timestamp;
}
