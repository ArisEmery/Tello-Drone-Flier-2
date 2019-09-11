package com.company;

import com.company.Messages.Message;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPcommunicator {

    private InetAddress droneAddress;    //127.0.0.1
    private int dronePort;
    private DatagramSocket udpClient;
    private byte[] bytesToSent;
    private byte[] bytesReceived;

    public UDPcommunicator(String droneAddress,int dronePort) throws UnknownHostException, SocketException {
        this.droneAddress = InetAddress.getByName(droneAddress);
        this.dronePort = dronePort;
        DatagramSocket udpClient =  new DatagramSocket();
        udpClient.setSoTimeout(1000);
    }

    public void sendMessage(Message message) throws IOException {
        DatagramPacket datagramPacket;
        bytesToSent = message.messageContents.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
    }
}
