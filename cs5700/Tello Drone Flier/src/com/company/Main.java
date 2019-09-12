package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Mission> generateMissions(){
        ArrayList<Mission> myMissions = new ArrayList<Mission>();
        //Supported messages: command, takeoff, land, up, down, left, right, forward, back, cw, cww,
        //stop, speed?, battery?, and time?

        //Mission 1
        ArrayList<String> mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("up 50");
        mission.add("left 50");
        mission.add("land");
        Mission newMission = new Mission(mission);
        myMissions.add(newMission);

        //Mission 2
        mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("left 100");
//        mission.add("right 100");
        mission.add("cw 180");
        mission.add("cww 180");
        mission.add("land");
        newMission = new Mission(mission);
        myMissions.add(newMission);


        //Mission 3
        mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("left 100");
        mission.add("cw 360");
        mission.add("up 50");
        mission.add("forward 50");
        mission.add("back 150");
        mission.add("cw 360");
        mission.add("land");
        newMission = new Mission(mission);
        myMissions.add(newMission);



        return myMissions;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        //-------- Put drone in command mode ---------
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        Main main = new Main();
        ArrayList<Mission> missions = main.generateMissions();
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
        System.out.println("Would you like to fly mission 1, mission 2, or mission 3?");
        userChoice = scanner.nextInt();
        System.out.println("Awesome! Here we go...");

        Flier flier = new Flier(droneAddress,dronePort);

        flier.launchMisson(missions.get(userChoice-1));

    }
}
