package com.company.Messages;

public class LandMessage extends Message {
    public LandMessage() {
        messageContents = "land";
        report = new MessageSent();
        validator = new BasicMessage();
    }
}
