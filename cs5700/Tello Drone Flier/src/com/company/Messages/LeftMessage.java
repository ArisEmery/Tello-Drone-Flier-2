package com.company.Messages;

public class LeftMessage extends Message{
    public LeftMessage(int cm) {
        messageContents = "left " + Integer.toString(cm);
        report = new MessageSent();
    }
}