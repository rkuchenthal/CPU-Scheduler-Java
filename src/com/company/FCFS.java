package com.company;

import java.util.ArrayList;

public class FCFS {

    public static void FcfsAlg(ArrayList<Inputs> inputList){

        printList(inputList);
        FcfsWaitOutput(inputList);
        //TODO print throughput
        System.out.println("                <><> end FCFS <><>");
    }

    //prints the wait time for each process to access the cpu
    public static void FcfsWaitOutput(ArrayList<Inputs> inputList){
        double totTime = 0, totProcesses = 0;
        ArrayList<Integer> turnAroundTimes = new ArrayList();

        for(int i = 0; i < inputList.size();i++){
            int id = inputList.get(i).id;
            int waitTime =  WaitTime(inputList, i);
            //TODO construct output
            System.out.println("fcfs wait of p" + id + " = " + waitTime);
            totTime += waitTime;
            totProcesses++;
            turnAroundTimes.add(inputList.get(i).time);
        }
        System.out.println("average wait time for "+ (int)totProcesses + " procs = " +(totTime/totProcesses));

        //print out turn-around times and turn-around avg
        TurnAroundTimeOutput(turnAroundTimes, inputList);

    }

    //prints all turn-around times and avg
    public static void TurnAroundTimeOutput(ArrayList<Integer> times, ArrayList<Inputs> proccesIDs){
        double totTurnTime = 0,totProcesses = 0;

        for(int i = 0; i< times.size(); i++){
            totTurnTime += times.get(i);
            System.out.println("fcfs turn-around time for p" +proccesIDs.get(i).id +" = " + (int)totTurnTime);
            totProcesses++;
        }

        System.out.println("average turn-around for "+ (int)totProcesses + " procs = " + totTurnTime/totProcesses);
    }

    //calculates the total wait time of each process
    public static int WaitTime(ArrayList<Inputs> list, int counter){
        int waitTime = 0;

        if(counter == 0) return 0;
        else{
            for (int i = 0; i < counter; i++){
                waitTime += list.get(i).time;
            }
            return waitTime;
        }

    }

    //prints the input the user inputted (req output format for assignment)
    public static void printList(ArrayList<Inputs> list){
        System.out.println("Process list in FCFS order as entered:");
        for( int i = 0; i < list.size(); i++){
            System.out.print( list.get(i).id + " ");
            System.out.print(list.get(i).time + " ");
            System.out.println(list.get(i).priority);
        }
        System.out.println("End of list.");
        System.out.println("");
    }


}
