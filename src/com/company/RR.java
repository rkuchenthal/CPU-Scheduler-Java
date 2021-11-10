package com.company;

import java.util.ArrayList;

public class RR {
    public static void RrAlg(ArrayList<Inputs> inputList){
        printList(inputList);
        //todo create round robin arraylists and cycle them per time slices
        //todo calculate
        TaTime(inputList, 1, 0);
        //todo
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

    public static void TaTime(ArrayList<Inputs> list, int q, int o){
        ArrayList<Integer> burstTime = new ArrayList();
        ArrayList<Integer> process = new ArrayList();
        ArrayList<Integer> waiTime = new ArrayList();
        int time=0,quantum = q, overhead = o;

        for(int i =0; i < list.size();i++){
            burstTime.add(list.get(i).time);
            process.add(list.get(i).time);
        }

        //https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
        while(true)
        {
            boolean done = true;

            // Traverse all processes one by one repeatedly
            for (int i = 0 ; i < process.size(); i++)
            {
                // If burst time of a process is greater than 0
                // then only need to process further
                if (burstTime.get(i) > 0)
                {
                    done = false; // There is a pending process

                    if (burstTime.get(i) > quantum)
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        time += quantum;

                        // Decrease the burst_time of current process
                        // by quantum
                        burstTime.get(i -= quantum) ;
                    }

                    // If burst time is smaller than or equal to
                    // quantum. Last cycle for this process
                    else
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        time +=  burstTime.get(i);

                        // Waiting time is current time minus time
                        // used by this process
                        waiTime.get(i = time - burstTime.get(i));

                        // As the process gets fully executed
                        // make its remaining burst time = 0
                        burstTime.get(i = 0) ;
                    }
                }
            }

            // If all processes are done
            if (done == true)
                break;
        }
    }


}
