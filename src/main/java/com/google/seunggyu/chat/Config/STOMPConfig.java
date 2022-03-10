package com.google.seunggyu.chat.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class STOMPConfig implements WebSocketMessageBrokerConfigurer {


    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/stomp/chat").withSockJS();
    }


    public void configureMessageBroker(MessageBrokerRegistry config) {
        //send 처리
        config.setApplicationDestinationPrefixes("/public");
        //broker 등록
        config.enableSimpleBroker("/sub");
    }

}
