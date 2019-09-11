package com.company.Messages;

import java.nio.charset.StandardCharsets;

//parent class for the following messages:
//stop, speed?, battery?, and time?
public class Message {

    public String messageContents;
    public Report report;

    public Message(){
        this.messageContents=null;
    }

    public byte[] encode(){
        return messageContents.getBytes(StandardCharsets.UTF_8);
    }

    public void printMessageContents(){
        System.out.println(messageContents);
    }
}
