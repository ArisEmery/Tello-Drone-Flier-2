package com.company.Test;

import com.company.Mission;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestMission {
    @Test
    public void testMissionCreation(){
        ArrayList<String> mission = new ArrayList<String>();
        mission.add("takeoff");
        mission.add("up 50");
        mission.add("left 50");
        mission.add("land");
        Mission newMission = new Mission(mission);
        assertEquals(newMission.getMissionCommands().get(0),"takeoff");
        assertEquals(newMission.getMissionCommands().get(1),"up 50");
        assertEquals(newMission.getMissionCommands().get(2),"left 50");
        assertEquals(newMission.getMissionCommands().get(3),"land");

    }

}
