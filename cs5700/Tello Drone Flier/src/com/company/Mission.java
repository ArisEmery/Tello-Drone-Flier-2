package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Mission {
    public ArrayList<String> missionCommands = new ArrayList<String>();

    public Mission (ArrayList<String> missionCommands) {
        this.missionCommands=missionCommands;
    }

    public void printMission(){
        Iterator<String> iter = missionCommands.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
    }

    public ArrayList<String> getMissionCommands(){
        return missionCommands;
    }
}
