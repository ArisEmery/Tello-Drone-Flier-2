package com.company.Messages;


//TODO message not recognized by simulator
public class StopMessage extends Message {
    public StopMessage() {
        messageContents = "stop";
        report = new MessageSent();
        validator = new BasicMessage();
    }
}