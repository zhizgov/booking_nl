package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChatMessageTest {
    //happy flow
    @Test
    void chatMessageConstructor() {
        //arrange
        ChatMessage actualChatMessage = new ChatMessage();
        //act
        actualChatMessage.setDate("2020-03-01");
        actualChatMessage.setMessage("Hello");
        actualChatMessage.setReceiverName("Receiver Name");
        actualChatMessage.setSenderName("Sender Name");
        String actualToStringResult = actualChatMessage.toString();
        //assert
        assertEquals("2020-03-01", actualChatMessage.getDate());
        assertEquals("Hello", actualChatMessage.getMessage());
        assertEquals("Receiver Name", actualChatMessage.getReceiverName());
        assertEquals("Sender Name", actualChatMessage.getSenderName());
        assertEquals("ChatMessage(senderName=Sender Name, receiverName=Receiver Name, message=Hello,"
                + " date=2020-03-01)", actualToStringResult);
    }


}

