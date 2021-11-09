package com.company;

import java.util.ArrayList;

public class Utils {

    //prints the wait time for each process to access the cpu
    public static void WaitOutput(ArrayList<Inputs> inputList, String scheduler){
        double totTime = 0, totProcesses = 0;
        ArrayList<Integer> turnAroundTimes = new ArrayList();

        for(int i = 0; i < inputList.size();i++){
            int id = inputList.get(i).id;
            int waitTime =  Utils.WaitTime(inputList, i);
            System.out.println(scheduler+" wait of p" + id + " = " + waitTime);
            //collecting info to compute avg wait time for cpu access
            totTime += waitTime;
            totProcesses++;
            turnAroundTimes.add(inputList.get(i).time);
        }
        System.out.println("average wait time for "+ (int)totProcesses + " procs = " +(totTime/totProcesses));

        //print out turn-around times and turn-around avg
        TurnAroundTimeOutput(turnAroundTimes,inputList,scheduler);

    }
    //prints all turn-around times and avg
    public static void TurnAroundTimeOutput(ArrayList<Integer> times, ArrayList<Inputs> proccesIDs, String scheduler){
        double turnTime = 0,totTurnTime = 0,totProcesses = 0;

        //iterate through the time list that has the same size as the proccesIDs and add up all
        // times for all process's and at same time gather info to compute avg turn-around time.
        for(int i = 0; i< times.size(); i++){
            turnTime += times.get(i);
            System.out.println(scheduler+" turn-around time for p" +proccesIDs.get(i).id +" = " + (int)turnTime);
            totProcesses++;
            totTurnTime += turnTime;
        }

        System.out.println("average turn-around for "+ (int)totProcesses + " procs = " + totTurnTime/totProcesses);
    }

    //calculates the total wait time of each process
    public static int WaitTime(ArrayList<Inputs> list, int counter){
        int waitTime = 0;

        //the first process will always have 0 waitTime
        if(counter == 0) return 0;
            //for all others we iterate up to that point in the list and add up the waitTime
        else{
            for (int i = 0; i < counter; i++){
                waitTime += list.get(i).time;
            }
            return waitTime;
        }
    }


}
