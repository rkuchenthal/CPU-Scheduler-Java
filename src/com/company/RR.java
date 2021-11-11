package com.company;

import java.util.ArrayList;

public class RR {
    public static void RrAlg(ArrayList<Inputs> inputList){

        printList(inputList);

        //vary the time quantum q from 1 to 5 milliseconds (ms).
        //Also, for each q selected, vary the overhead of a context
        // switch from 0 ms up to q itself
        for( int i = 1; i<=5;i++){
            for( int j = 0; j<=i;j++){
                TaTime(inputList, i, j);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("                <><> end Preemptive RR Schedule <><>");
        System.out.println();
    }

    //prints the input the user inputted (req output format for assignment)
    public static void printList(ArrayList<Inputs> list){
        System.out.println("Process list in RR order:");
        for( int i = 0; i < list.size(); i++){
            System.out.print( list.get(i).id + " ");
            System.out.print(list.get(i).time + " ");
            System.out.println(list.get(i).priority);
        }
        System.out.println("End of list.");
        System.out.println();
    }

    //calculate the turn around time (TA) for all process,
    //the throughput, and the avg TA time.
    public static void TaTime(ArrayList<Inputs> list, int quantum, int overhead){
        System.out.println("preemptive RR schedule, quantum = "+quantum+" overhead = "+overhead);
        ArrayList<Integer> burstTime = new ArrayList();
        int totTime=0,pTime = 0,processTTC = 0;

        //initializing burst time[] with all time requirements
        for(int i = 0; i< list.size();i++){
             burstTime.add(list.get(i).time);
        }

        while(true) {
            //check time req against quantum
            for (int i = 0; i < burstTime.size(); i++) {

                //remaining time process will take
                pTime = burstTime.get(i);

                //ignores this process since it is complete
                if(pTime == 0);

                //if the process time is less than the quantum set process time to zero in list,// increment total time then print results
                else if (pTime <= quantum) {
                    burstTime.set(i, 0);
                    totTime += pTime;
                    // print out TA time results
                    System.out.println("RR TA time for finished p" + list.get(i).id + " = " + totTime
                            + ",  needed: " + list.get(i).time + " ms, and: "
                            + (int)Math.ceil((double)list.get(i).time/(double)quantum) + " time slices.");
                    processTTC += totTime;

                    //check to see if current process is final one to be completed
                    if(SumOfList(burstTime) == 0) {
                        double listSize = list.size();
                        double throughput =listSize/totTime;

                        //print throughput
                        System.out.println("RR Throughput, " + list.size() + " p, with q: " + quantum +
                                ", o: " + overhead + ", is: "
                                + throughput + " p/ms, or " + (1000 * throughput)+" p/us");
                        //print avg TA time
                        System.out.println("Average RR TA, "+listSize+" p, with q: " + quantum +
                                           ", o: " +overhead+", is: "+(double)processTTC/listSize);

                        //end loops aka finish algorithm
                        break;
                    }else{
                        totTime += overhead;
                    }

                }
                else if (pTime > quantum) {
                    burstTime.set(i, pTime - quantum);
                    totTime += quantum + overhead;

                }
            }
            //check to see if we need to run through the input list again
            //aka are there unfinished processes
            if(SumOfList(burstTime) == 0) {
                break;
            }
        }

    }

    //gives the sum of all values in a integer arrayList
    public static int SumOfList(ArrayList<Integer> timeList){
        int sum = 0;
        for(int j =0; j < timeList.size();j++){
            sum += timeList.get(j);
        }
        return sum;
    }


}
