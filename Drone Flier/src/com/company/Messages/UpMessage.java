package com.company.Messages;

public class UpMessage extends Message{
    public UpMessage(int cm) {
        messageContents = "up " + Integer.toString(cm);
        report = new MessageSent();
        validator = new MessageWithCentimeters();
    }

}
