package com.company.Messages;

public interface Validator {
    boolean isValid(String messageContents);
}

class MessageWithDegrees implements Validator{
    public boolean isValid(String messageContents){
        String[] specialString = messageContents.split(" ");
        int value = Integer.parseInt(specialString[1]);
        if(value >= 1 && value <=360){
            return true;
        }
        return false;
    }
}

class MessageWithCentimeters implements Validator{
    public boolean isValid(String messageContents){
        String[] specialString = messageContents.split(" ");
        int value = Integer.parseInt(specialString[1]);
        if(value >= 20 && value <=500){
            return true;
        }
        return false;
    }
}

class BasicMessage implements Validator{
    public boolean isValid(String messageContents){
        return true;
    }
}