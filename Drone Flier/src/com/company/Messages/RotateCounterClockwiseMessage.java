package com.company.Messages;

public class RotateCounterClockwiseMessage extends Message{
    public RotateCounterClockwiseMessage(int degrees) {
        messageContents = "cww " + Integer.toString(degrees);
        report = new MessageSent();
        validator = new MessageWithDegrees();
    }
}
