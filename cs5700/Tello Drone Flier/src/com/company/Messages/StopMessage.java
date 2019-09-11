package com.company.Messages;

public class StopMessage extends Message {
    public StopMessage() {
        messageContents = "stop";
        report = new MessageSent();
    }
}