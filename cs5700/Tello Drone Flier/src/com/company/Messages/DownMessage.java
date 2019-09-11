package com.company.Messages;

public class DownMessage extends Message{
    public DownMessage(int cm) {
        messageContents = "down " + Integer.toString(cm);
        report = new MessageSent();
    }
}