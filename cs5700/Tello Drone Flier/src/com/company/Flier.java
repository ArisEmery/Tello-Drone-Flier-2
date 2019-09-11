package com.company;

import com.company.Messages.CommandMessage;
import com.company.Messages.LandMessage;
import com.company.Messages.RotateClockwiseMessage;
import com.company.Messages.TakeoffMessage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

//TODO: All commands may need a sleep command in between to give the drone time to complete its maneuver before
//TODO: moving on to the next one

public class Flier {
    UDPcommunicator udpCommunicator;
    public Flier() throws SocketException, UnknownHostException {
        udpCommunicator = new UDPcommunicator("127.0.0.1",8889);
    }

    public void initiateCommandMode() throws IOException {
        System.out.println("Put drone in command mode...");
        CommandMessage commandMessage = new CommandMessage();
        String reply = null;
        int maxRetries = 3;
        while (maxRetries > 0) {
            udpCommunicator.sendMessage(commandMessage);
            reply=udpCommunicator.receiveMessage();
            if (reply.equals("ok")) {
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
    }

    public void launchMisson(Mission mission){

    }

    public static void main(String[] args) throws IOException {
        //-------- Put drone in command mode ---------
        Flier flier = new Flier();
        flier.initiateCommandMode();
        System.out.println("Takeoff...");
        TakeoffMessage takeoffMessage = new TakeoffMessage();
        String reply = null;
        flier.udpCommunicator.sendMessage(takeoffMessage);
        reply=flier.udpCommunicator.receiveMessage();
        RotateClockwiseMessage rotateClockwiseMessage = new RotateClockwiseMessage(360);
        reply = null;
        flier.udpCommunicator.sendMessage(rotateClockwiseMessage);
        reply=flier.udpCommunicator.receiveMessage();
        LandMessage landMessage = new LandMessage();
        reply = null;
        flier.udpCommunicator.sendMessage(landMessage);
        reply=flier.udpCommunicator.receiveMessage();
        System.out.println("Reply: "+reply);



    }
}
