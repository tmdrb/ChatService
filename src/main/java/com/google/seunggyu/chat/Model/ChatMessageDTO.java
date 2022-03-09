package com.google.seunggyu.chat.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {

    private int type;
    private String roomid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

}
