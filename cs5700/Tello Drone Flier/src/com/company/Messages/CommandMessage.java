package com.company.Messages;

public class CommandMessage extends Message {
    public CommandMessage(){
        messageContents="command";
        report=new MessageSent();
    }
}
