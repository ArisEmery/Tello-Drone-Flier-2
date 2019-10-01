package com.company.Messages;

public class TakeoffMessage extends Message {
    public TakeoffMessage() {
        messageContents = "takeoff";
        report = new MessageSent();
        validator = new BasicMessage();
    }
}
