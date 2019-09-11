package com.company.Messages;

import java.nio.charset.StandardCharsets;

//
//public interface Message {
//
//    public String command;
//    byte[] bytesToSent;
//
//    public Message(String command){
//        this.command=command;
//    }
//
//    public byte[] encode(){
//        return command.getBytes(StandardCharsets.UTF_8);
//    }
//}

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
