package com.PCD.ReCraftMarket.controller.chat;

import lombok.*;

import java.awt.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
}
