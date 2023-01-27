package com.example.bookingnl.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessage {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    public enum status{
        MESSAGE, LEAVE, JOIN
    }
}
