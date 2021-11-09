package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class HPF {



    public static void HpfAlg(ArrayList<Inputs> inputList){

        ArrayList<Inputs> sortedInputs = new ArrayList();

        printList(inputList);

        // assign sortedInputs the correctly ordered priority values in inputList
        sortedInputs = Sorter(inputList);

        //TODO delete do while
        /*do{
            Sorter(inputList);
            for(int i = 0; i <inputList.size();i++){
                //for (int j = 0; i <sortedInputs.size();j++) {
                    sortedInputs.add(inputList.get(i));
                 //   break;
               //}
            }
            break;
        }while(true);*/

        printList(sortedInputs);
        HpfWaitOutput(sortedInputs);
        //TODO print throughput
        System.out.println("                <><> end HPF <><>");
    }


    public static ArrayList<Inputs> Sorter(ArrayList<Inputs> inputList ){
        for (int i = 0; i < inputList.size(); i++) {

            for (int j = inputList.size() - 1; j > i; j--) {
                if (inputList.get(i).priority > inputList.get(j).priority) {

                    Inputs tmp = new Inputs(inputList.get(i).id,inputList.get(i).time,inputList.get(i).priority) ;
                    inputList.set(i,inputList.get(j)) ;
                    inputList.set(j,tmp);

                }

            }

        }

        return inputList;
    }


    //prints the wait time for each process to access the cpu
    public static void HpfWaitOutput(ArrayList<Inputs> inputList){
        double totTime = 0, totProcesses = 0;
        ArrayList<Integer> turnAroundTimes = new ArrayList();

        for(int i = 0; i < inputList.size();i++){
            int id = inputList.get(i).id;
            int waitTime =  WaitTime(inputList, i);
            System.out.println("fcfs wait of p" + id + " = " + waitTime);
            //collecting info to compute avg wait time for cpu access
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

        //iterate through the time list that has the same size as the proccesIDs and add up all
        // times for all process's and at same time gather info to compute avg turn-around time.
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

    //prints the input the user inputted (req output format for assignment)
    public static void printList(ArrayList<Inputs> list){
        System.out.println("Process list in HPF order:");
        for( int i = 0; i < list.size(); i++){
            System.out.print( list.get(i).id + " ");
            System.out.print(list.get(i).time + " ");
            System.out.println(list.get(i).priority);
        }
        System.out.println("End of list.");
        System.out.println("");
    }
}
