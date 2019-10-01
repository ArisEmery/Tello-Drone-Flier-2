package com.company.Messages;

public class BackMessage extends Message{
    public BackMessage(int cm) {
        messageContents = "back " + Integer.toString(cm);
        report = new MessageSent();
        validator = new MessageWithCentimeters();
    }
}