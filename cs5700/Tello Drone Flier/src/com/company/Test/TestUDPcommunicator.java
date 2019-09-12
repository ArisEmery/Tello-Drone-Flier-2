package com.company.Test;

import com.company.Messages.CommandMessage;
import com.company.Messages.RotateClockwiseMessage;
import com.company.Messages.TimeMessage;
import com.company.Messages.UpMessage;
import com.company.UDPcommunicator;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Time;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestUDPcommunicator {



    @Test
    public void testMessageValidation() throws IOException {
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        UDPcommunicator udPcommunicator = new UDPcommunicator(droneAddress,dronePort);
        UpMessage upMessage = new UpMessage(3000);
        boolean result = udPcommunicator.sendMessage(upMessage);
        assertEquals(result,false);
        upMessage = new UpMessage(300);
        result = udPcommunicator.sendMessage(upMessage);
        assertEquals(result,true);
        RotateClockwiseMessage rotateClockwiseMessage = new RotateClockwiseMessage(361);
        result = udPcommunicator.sendMessage(rotateClockwiseMessage);
        assertEquals(result,false);
        rotateClockwiseMessage = new RotateClockwiseMessage(360);
        result = udPcommunicator.sendMessage(rotateClockwiseMessage);
        assertEquals(result,true);
        TimeMessage timeMessage = new TimeMessage();
        result = udPcommunicator.sendMessage(timeMessage);
        assertEquals(true,result);
    }

    @Test
    public void testMessageSendAndReceiveAndConstructor() throws IOException {
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        UDPcommunicator udPcommunicator = new UDPcommunicator(droneAddress,dronePort);
        CommandMessage commandMessage = new CommandMessage();
        boolean result = udPcommunicator.sendMessage(commandMessage);
        String reply= udPcommunicator.receiveMessage();
        assertEquals(reply,"ok");
        assertEquals(result,true);

    }

}
