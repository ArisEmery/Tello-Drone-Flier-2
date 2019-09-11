package com.company.Messages;

public class SpeedMessage extends Message {
    public SpeedMessage() {
        messageContents = "speed?";
        report = new MessageSent();
    }
}