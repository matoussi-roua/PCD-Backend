package com.PCD.ReCraftMarket.Configuration;

import com.PCD.ReCraftMarket.controller.chat.ChatMessage;
import com.PCD.ReCraftMarket.controller.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component //indicates that a class is a Spring-managed component
@RequiredArgsConstructor //generates constructors for initializing final or @NonNull fields
@Slf4j //generates a logger field for logging messages in the class
//i will log a few info whene user leave the chat
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;
    @EventListener
    public void handleWebSocketDisconnectListener(
            SessionDisconnectEvent event
    ){
        StompHeaderAccessor headerAccessor= StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        //ChatController.userList.remove(username);

        if(username != null) {
            log.info("User Disconnected : " + username);
           var chatMessage = ChatMessage.builder()
                   .type(MessageType.LEAVE)
                   .sender(username)
                   .build();
            messageTemplate.convertAndSend("/topic/public", chatMessage);
        //implementation
        }
    }
    //we want to inform the users that a user just left the chat
}
