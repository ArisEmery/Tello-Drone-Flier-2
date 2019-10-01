package com.company.Messages;

public class ForwardMessage extends Message{
    public ForwardMessage(int cm) {
        messageContents = "forward " + Integer.toString(cm);
        report = new MessageSent();
        validator = new MessageWithCentimeters();
    }
}