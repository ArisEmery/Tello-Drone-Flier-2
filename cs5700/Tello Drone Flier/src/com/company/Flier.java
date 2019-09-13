package com.company;

import com.company.Messages.*;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TODO: All commands may need a sleep command in between to give the drone time to complete its maneuver before
//TODO: moving on to the next one

public class Flier {
    private UDPcommunicator udpCommunicator;
    public Flier(String droneAddress, int dronePort) throws SocketException, UnknownHostException {
        udpCommunicator = new UDPcommunicator(droneAddress,dronePort);
    }

    public boolean initiateCommandMode() throws IOException {
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
        if (maxRetries <=0){
            return false;
        }
        return true;
    }

    public UDPcommunicator getUDPcommunicator(){
        return udpCommunicator;
    }

    public boolean launchMisson(Mission mission) throws IOException, InterruptedException {
        //Supported messages: command, takeoff, land, up, down, left, right, forward, back, cw, cww,
        //speed?, battery?, and time?
        initiateCommandMode();
        Iterator<String> iter = mission.missionCommands.iterator();
        while (iter.hasNext()) {
            Message nextMessageToSend=null;
            String currentCommand=iter.next();
            int unitOfDegreesOrDistance=0;
            String[] specialString = currentCommand.split(" ");
            if(specialString.length>1){
                unitOfDegreesOrDistance=Integer.parseInt(specialString[1]);
            }

            switch (specialString[0]){
                case "takeoff":
                    System.out.println("Taking off...");
                    nextMessageToSend=new TakeoffMessage();
                    break;
                case "land":
                    System.out.println("Landing...");
                    nextMessageToSend=new LandMessage();
                    break;
                case "up":
                    System.out.println("Going up by "+unitOfDegreesOrDistance +" cm...");
                    nextMessageToSend=new UpMessage(unitOfDegreesOrDistance);
                    break;
                case "down":
                    System.out.println("Going down by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new DownMessage(unitOfDegreesOrDistance);
                    break;
                case "left":
                    System.out.println("Going left by "+unitOfDegreesOrDistance +" cm...");
                    nextMessageToSend=new LeftMessage(unitOfDegreesOrDistance);
                    break;
                case "forward":
                    System.out.println("Going forward by "+unitOfDegreesOrDistance +" cm...");
                    nextMessageToSend=new ForwardMessage(unitOfDegreesOrDistance);
                    break;
                case "back":
                    System.out.println("Going back by "+unitOfDegreesOrDistance +" cm...");
                    nextMessageToSend=new BackMessage(unitOfDegreesOrDistance);
                    break;
                case "cw":
                    System.out.println("Rotating clockwise by "+unitOfDegreesOrDistance +" degrees...");
                    nextMessageToSend=new RotateClockwiseMessage(unitOfDegreesOrDistance);
                    break;
                case "cww":
                    System.out.println("Going counterclockwise by "+unitOfDegreesOrDistance +" degrees...");
                    nextMessageToSend=new RotateCounterClockwiseMessage(unitOfDegreesOrDistance);
                    break;
                case "stop":
                    System.out.println("Stopping...");
                    nextMessageToSend=new StopMessage();
                    break;
                case "speed?":
                    System.out.println("Checking speed...");
                    nextMessageToSend=new SpeedMessage();
                    break;
                case "battery?":
                    System.out.println("Checking battery...");
                    nextMessageToSend=new BatteryMessage();
                    break;
                case "time?":
                    System.out.println("Checking time...");
                    nextMessageToSend=new TimeMessage();
                    break;
            }
            udpCommunicator.sendMessage(nextMessageToSend);
            String reply = null;
            reply=udpCommunicator.receiveMessage();
            Thread.sleep(5000);



        }
        if(iter.hasNext()==false){
            return true;
        }
        return false;
    }



}
