package com.company;
import com.company.Messages.CommandMessage;
import com.company.Messages.Message;
import com.company.Messages.OkMessage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        CommandMessage commandMessage = new CommandMessage();
        commandMessage.report.reportState();
        OkMessage okMessage = new OkMessage();
        okMessage.report.reportState();
        String string = "Aris is ";
        int age = 22;
        System.out.println(string+ Integer.toString(age));
        
//        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");     //127.0.0.1
//        int dronePort = 8889;
//
//        DatagramSocket udpClient =  new DatagramSocket();
//        udpClient.setSoTimeout(1000);
//
//        //-------- Put drone in command mode ---------
//
//        System.out.println("Put drone in command mode...");
//
//        Message myMessage = new Message("command");
//        byte[] bytesToSent;
//        byte[] bytesReceived;
//        DatagramPacket datagramPacket;
//
//        String reply = null;
//        int maxRetries = 3;
//        while (maxRetries > 0) {
//
////            bytesToSent = request.getBytes(StandardCharsets.UTF_8);
//            datagramPacket = new DatagramPacket(myMessage.encode(), myMessage.encode().length, droneAddress, dronePort);
//            udpClient.send(datagramPacket);
//            System.out.println("Sent " + myMessage.command + " bytes to " + droneAddress.toString() + ":" + dronePort);
//
//            bytesReceived = new byte[64];
//            datagramPacket = new DatagramPacket(bytesReceived, 64);
//            try {
//                udpClient.receive(datagramPacket);
//            }
//            catch (SocketTimeoutException ex) {
//                datagramPacket = null;
//            }
//            if (datagramPacket != null) {
//                System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
//                reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
//                System.out.println("Receive " + reply);
//                if (reply.equals("ok")) {
//                    break;
//                }
//            }
//            System.out.println("Remaining retries: " + maxRetries);
//            maxRetries--;
//        }
//
//        if (reply == null || !reply.equals("ok"))
//            return;
//
//        //-------- take off ---------
//
//        System.out.println("Takeoff...");
//
//        String request = "takeoff";
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
//        System.out.println("Time?");
//
//        request = "time?";
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
////        if (reply == null || !reply.equals("ok"))
////            return;
//
//        Thread.sleep(5000);
//
//        //-------- land ---------
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
