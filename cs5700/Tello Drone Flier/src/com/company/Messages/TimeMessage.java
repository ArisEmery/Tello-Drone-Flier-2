package com.company.Messages;

public class TimeMessage extends Message {
    public TimeMessage() {
        messageContents = "time?";
        report = new MessageSent();
    }
}