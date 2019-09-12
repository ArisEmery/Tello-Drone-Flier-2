package com.company.Test;
import com.company.Messages.*;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
public class TestMessages {

    @Test
    public void testCentimeterMessages(){
        UpMessage upMessage = new UpMessage(501);
        assertEquals(false,upMessage.isValid());
        upMessage = new UpMessage(1);
        assertEquals(false,upMessage.isValid());
        upMessage = new UpMessage(20);
        assertEquals(true,upMessage.isValid());
        upMessage = new UpMessage(500);
        assertEquals(true,upMessage.isValid());
        upMessage = new UpMessage(250);
        assertEquals(true,upMessage.isValid());
    }


    @Test
    public void testDegreeMessages(){
        RotateClockwiseMessage rotateClockwiseMessage = new RotateClockwiseMessage(360);
        assertEquals(rotateClockwiseMessage.isValid(),true);
        rotateClockwiseMessage = new RotateClockwiseMessage(1);
        assertEquals(rotateClockwiseMessage.isValid(),true);
        rotateClockwiseMessage = new RotateClockwiseMessage(0);
        assertEquals(rotateClockwiseMessage.isValid(),false);
        rotateClockwiseMessage = new RotateClockwiseMessage(361);
        assertEquals(rotateClockwiseMessage.isValid(),false);
        rotateClockwiseMessage = new RotateClockwiseMessage(200);
        assertEquals(rotateClockwiseMessage.isValid(),true);
    }

    @Test
    public void testBasicMessages(){
        TakeoffMessage takeoffMessage = new TakeoffMessage();
        assertEquals(takeoffMessage.messageContents,"takeoff");
        assertEquals(true,takeoffMessage.isValid());
        LandMessage landMessage = new LandMessage();
        assertEquals(landMessage.messageContents,"land");
        assertEquals(true,landMessage.isValid());
        CommandMessage commandMessage = new CommandMessage();
        assertEquals(commandMessage.messageContents,"command");
        assertEquals(true,commandMessage.isValid());
    }



}
