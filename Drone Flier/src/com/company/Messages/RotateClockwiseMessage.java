package com.company.Messages;

public class RotateClockwiseMessage extends Message{
    public RotateClockwiseMessage(int degrees) {
        messageContents = "cw " + Integer.toString(degrees);
        report = new MessageSent();
        validator = new MessageWithDegrees();
    }
}
