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
    private ArrayList<Mission> Missions = new ArrayList<Mission>();
    public Flier(String droneAddress, int dronePort) throws SocketException, UnknownHostException {
        udpCommunicator = new UDPcommunicator(droneAddress,dronePort);
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

    public void launchMisson(Mission mission) throws IOException {
        //Supported messages: command, takeoff, land, up, down, left, right, forward, back, cw, cww,
        //stop, speed?, battery?, and time?
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
                    System.out.println("Going up by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new UpMessage(unitOfDegreesOrDistance);
                    break;
                case "down":
                    System.out.println("Going down by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new DownMessage(unitOfDegreesOrDistance);
                    break;
                case "left":
                    System.out.println("Going left by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new LeftMessage(unitOfDegreesOrDistance);
                    break;
                case "forward":
                    System.out.println("Going forward by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new ForwardMessage(unitOfDegreesOrDistance);
                    break;
                case "back":
                    System.out.println("Going back by "+unitOfDegreesOrDistance +"cm...");
                    nextMessageToSend=new BackMessage(unitOfDegreesOrDistance);
                    break;
                case "cw":
                    System.out.println("Rotating clockwise by "+unitOfDegreesOrDistance +"degrees...");
                    nextMessageToSend=new RotateClockwiseMessage(unitOfDegreesOrDistance);
                    break;
                case "cww":
                    System.out.println("Going counterclockwise by "+unitOfDegreesOrDistance +"degrees...");
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


        }
    }

    public void createNewMission(){

    }

    public static void main(String[] args) throws IOException {
        //-------- Put drone in command mode ---------
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        ArrayList<String> mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("up 300");
        mission.add("land");
        System.out.println("Welcome to the Telu Edu Drone Flier!");
        System.out.println("Would you like to specify the IP Address and Command Port for\n" +
                "the drone? (The default drone Address will be 127.0.0.1 and the default\n" +
                "port will be 8889. Press 1 for yes and 2 for no (default).");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        if (userChoice == 1){
            System.out.println("please specify your desired IP address: ");
            droneAddress = scanner.nextLine();
            System.out.println("please specify your desired command port: ");
            dronePort = scanner.nextInt();
        }


        Flier flier = new Flier(droneAddress,dronePort);

        Mission myMission = new Mission(mission);
        flier.launchMisson(myMission);







//
//
//        TakeoffMessage takeoffMessage = new TakeoffMessage();
//        String reply = null;
//        flier.udpCommunicator.sendMessage(takeoffMessage);
//        reply=flier.udpCommunicator.receiveMessage();
//        RotateClockwiseMessage rotateClockwiseMessage = new RotateClockwiseMessage(360);
//        reply = null;
//        flier.udpCommunicator.sendMessage(rotateClockwiseMessage);
//        reply=flier.udpCommunicator.receiveMessage();
//        LandMessage landMessage = new LandMessage();
//        reply = null;
//        flier.udpCommunicator.sendMessage(landMessage);
//        reply=flier.udpCommunicator.receiveMessage();
//        System.out.println("Reply: "+reply);



    }
}
