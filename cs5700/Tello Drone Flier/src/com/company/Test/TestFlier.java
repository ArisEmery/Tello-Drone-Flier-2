package com.company.Test;
import com.company.Flier;
import com.company.Messages.*;
import com.company.Mission;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestFlier {

    @Test
    public void testMissionLaunch() throws IOException, InterruptedException {
        String droneAddress="127.0.0.1";
        int dronePort=8889;
        ArrayList<String> mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("up 50");
        mission.add("left 50");
        mission.add("land");
        Mission newMission = new Mission(mission);
        Flier flier = new Flier(droneAddress,dronePort);
        flier.launchMisson(newMission);


    }
}
