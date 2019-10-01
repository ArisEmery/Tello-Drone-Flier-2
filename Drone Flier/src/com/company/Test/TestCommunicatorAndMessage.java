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
import static org.junit.Assert.assertNotEquals;

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


        RotateCounterClockwiseMessage rotateCounterClockwiseMessage = new RotateCounterClockwiseMessage(30);
        udPcommunicator.sendMessage(rotateCounterClockwiseMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


        DownMessage downMessage = new DownMessage(30);
        udPcommunicator.sendMessage(downMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


        UpMessage upMessage = new UpMessage(30);
        udPcommunicator.sendMessage(upMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


        LeftMessage leftMessage = new LeftMessage(30);
        udPcommunicator.sendMessage(leftMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


        RightMessage rightMessage = new RightMessage(30);
        udPcommunicator.sendMessage(rightMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


//        ForwardMessage forwardMessage = new ForwardMessage(30);
//        udPcommunicator.sendMessage(forwardMessage);
//        result = udPcommunicator.receiveMessage();
//        assertEquals(result,"ok");
        //Forward no returning OK message


        BackMessage backMessage = new BackMessage(30);
        udPcommunicator.sendMessage(backMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");


//        StopMessage stopMessage = new StopMessage();
//        udPcommunicator.sendMessage(stopMessage);
//        result=udPcommunicator.receiveMessage();
//        assertEquals("ok",result);
        //STOP message not recognized


        SpeedMessage speedMessage = new SpeedMessage();
        udPcommunicator.sendMessage(speedMessage);
        result = udPcommunicator.receiveMessage();
        assertNotEquals(result,null);


        BatteryMessage batteryMessage = new BatteryMessage();
        udPcommunicator.sendMessage(batteryMessage);
        result = udPcommunicator.receiveMessage();
        assertNotEquals(result,null);


        TimeMessage timeMessage = new TimeMessage();
        udPcommunicator.sendMessage(timeMessage);
        result = udPcommunicator.receiveMessage();
        assertNotEquals(result,null);


        LandMessage landMessage = new LandMessage();
        udPcommunicator.sendMessage(landMessage);
        result = udPcommunicator.receiveMessage();
        assertEquals(result,"ok");
    }
}
