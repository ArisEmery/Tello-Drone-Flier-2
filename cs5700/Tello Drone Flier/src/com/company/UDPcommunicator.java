package com.company;

import com.company.Messages.Message;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPcommunicator {

    private InetAddress droneAddress;    //127.0.0.1
    private int dronePort;
    private DatagramSocket udpClient;

    public UDPcommunicator(String droneAddress,int dronePort) throws UnknownHostException, SocketException {
        this.droneAddress = InetAddress.getByName(droneAddress);
        this.dronePort = dronePort;
        this.udpClient =  new DatagramSocket();
        this.udpClient.setSoTimeout(1000);
    }

    public boolean sendMessage(Message message) throws IOException {
        if(!message.isValid()){
            System.out.println("Error, invalid message, won't attempt to send");
            return false;
        }
        DatagramPacket datagramPacket;
        datagramPacket = new DatagramPacket(message.encode(), message.encode().length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + message.messageContents + " bytes to " + droneAddress.toString() + ":" + dronePort);
        return true;
    }

    public String receiveMessage() throws IOException {
        byte[] bytesReceived=new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 64);
        String reply="none"; //TODO change this here
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Receive " + reply);

        }
//        if (reply == null || !reply.equals("ok"))
//            return "Error!";
        return reply;
    }
}
