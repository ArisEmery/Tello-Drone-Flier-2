package com.company.Messages;

public interface Report {
    void reportState();
}

class MessageSent implements Report{
    public void reportState(){
        System.out.println("This message was sent from the flier to the drone");
    }
}

class MessageReceived implements Report{
    public void reportState(){
        System.out.println("This message was received from the drone");
    }
}
