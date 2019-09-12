package com.company.Messages;

public class BatteryMessage extends Message {
    public BatteryMessage() {
        messageContents = "battery?";
        report = new MessageSent();
        validator = new BasicMessage();
    }
}