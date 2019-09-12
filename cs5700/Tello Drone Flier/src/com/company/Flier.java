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

    public void launchMisson(Mission mission){
        Iterator<String> iter = mission.missionCommands.iterator();
        while (iter.hasNext()) {
            switch (iter.next()){
                case "takeoff":
                    System.out.println("sd");
            }
            System.out.print(iter.next() + ", ");
        }
    }

    public void createNewMission(){

    }

    public static void main(String[] args) throws IOException {
        //-------- Put drone in command mode ---------
        String droneAddress="127.0.0.1";
        int dronePort=8889;
//        RotateClockwiseMessage upMessage = new RotateClockwiseMessage(361);
//        System.out.println(upMessage.isValid());
//        System.out.println("Welcome to the Telu Edu Drone Flier!");
//        System.out.println("Would you like to specify the IP Address and Command Port for\n" +
//                "the drone? (The default drone Address will be 127.0.0.1 and the default\n" +
//                "port will be 8889. Press 1 for yes and 2 for no (default).");
//        Scanner scanner = new Scanner(System.in);
//        int userChoice = scanner.nextInt();
//        scanner.nextLine();
//        if (userChoice == 1){
//            System.out.println("please specify your desired IP address: ");
//            droneAddress = scanner.nextLine();
//            System.out.println("please specify your desired command port: ");
//            dronePort = scanner.nextInt();
//        }
//        ArrayList<String> mission = new ArrayList<String>();
//        mission.add("takeoff");
//        mission.add("rotate 360");
//        mission.add("land");

//        Mission myMission = new Mission(mission);
        Flier flier = new Flier(droneAddress,dronePort);
        flier.initiateCommandMode();
//        flier.launchMisson(myMission);
//
//
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
