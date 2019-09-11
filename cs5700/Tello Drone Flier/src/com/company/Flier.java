package com.company;

import com.company.Messages.CommandMessage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Flier {
    public Flier(){

    }

    public void initiateCommandMode() throws IOException {
        System.out.println("Put drone in command mode...");
        CommandMessage commandMessage = new CommandMessage();
        UDPcommunicator udpCommunicator = new UDPcommunicator("127.0.0.1",8889);
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

    public static void main(String[] args)  {

        //-------- Put drone in command mode ---------





        //-------- take off ---------

//        System.out.println("Takeoff...");
//
//        request = "takeoff";
//        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
//        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
//        udpClient.send(datagramPacket);
//        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);
//
//        reply = null;
//        bytesReceived = new byte[64];
//        datagramPacket = new DatagramPacket(bytesReceived, 64);
//        try {
//            udpClient.receive(datagramPacket);
//        }
//        catch (SocketTimeoutException ex) {
//            datagramPacket = null;
//        }
//        if (datagramPacket != null) {
//            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
//            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
//            System.out.println("Receive " + reply);
//        }
//
//        if (reply == null || !reply.equals("ok"))
//            return;
//
//        Thread.sleep(5000);
//
//        //-------- rotate ---------
//
//        System.out.println("Rotate...");
//
//        request = "cw 360";
//        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
//        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
//        udpClient.send(datagramPacket);
//        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);
//
//        reply = null;
//        bytesReceived = new byte[64];
//        datagramPacket = new DatagramPacket(bytesReceived, 64);
//        try {
//            udpClient.receive(datagramPacket);
//        }
//        catch (SocketTimeoutException ex) {
//            datagramPacket = null;
//        }
//        if (datagramPacket != null) {
//            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
//            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
//            System.out.println("Receive " + reply);
//        }
//
//        if (reply == null || !reply.equals("ok"))
//            return;
//
//        Thread.sleep(5000);
//
//        //-------- land ---------
//
//        request = "land";
//        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
//        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
//        udpClient.send(datagramPacket);
//        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);
//
//        bytesReceived = new byte[64];
//        datagramPacket = new DatagramPacket(bytesReceived, 64);
//        try {
//            udpClient.receive(datagramPacket);
//        }
//        catch (SocketTimeoutException ex) {
//            datagramPacket = null;
//        }
//        if (datagramPacket != null) {
//            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
//            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
//            System.out.println("Received " + reply);
//        }
    }
}
