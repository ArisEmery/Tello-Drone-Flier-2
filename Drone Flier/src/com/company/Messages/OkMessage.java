package com.company.Messages;

public class OkMessage extends Message{
    public OkMessage(){
        messageContents="ok";
        report=new MessageReceived();
    }
}
