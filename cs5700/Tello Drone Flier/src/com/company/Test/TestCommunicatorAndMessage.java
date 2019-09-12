package com.company.Test;
import com.company.Flier;
import com.company.Messages.*;
import com.company.Mission;
import com.company.UDPcommunicator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCommunicatorAndMessage {
    @Test
    public void testForOK() throws IOException {
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        UDPcommunicator udPcommunicator = new UDPcommunicator(droneAddress,dronePort);
        CommandMessage commandMessage = new CommandMessage();
        udPcommunicator.sendMessage(commandMessage);
        String result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");

        TakeoffMessage takeoffMessage = new TakeoffMessage();
        udPcommunicator.sendMessage(takeoffMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");

        RotateClockwiseMessage rotateClockwiseMessage = new RotateClockwiseMessage(30);
        udPcommunicator.sendMessage(rotateClockwiseMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


        DownMessage upMessage = new DownMessage(30);
        udPcommunicator.sendMessage(upMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");
    }
}
