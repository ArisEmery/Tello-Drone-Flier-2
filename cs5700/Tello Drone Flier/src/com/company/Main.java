package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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

    }
}
