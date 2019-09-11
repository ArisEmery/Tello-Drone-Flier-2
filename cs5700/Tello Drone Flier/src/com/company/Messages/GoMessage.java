package com.company.Messages;

public class GoMessage extends Message{
    public GoMessage(int x, int y, int z, int speed) {
        messageContents = "go " + Integer.toString(x)+ " " + Integer.toString(y)+ " "+
        Integer.toString(z)+ " "+Integer.toString(speed);
        report = new MessageSent();
    }
}
