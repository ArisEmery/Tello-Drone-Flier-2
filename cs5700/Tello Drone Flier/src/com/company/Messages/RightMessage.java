package com.company.Messages;

public class RightMessage extends Message{
    public RightMessage(int cm) {
        messageContents = "right " + Integer.toString(cm);
        report = new MessageSent();
    }
}
