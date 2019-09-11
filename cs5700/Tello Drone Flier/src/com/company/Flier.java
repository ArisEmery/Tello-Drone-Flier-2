package com.company;

import com.company.Messages.CommandMessage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

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



    }
}
