package com.company;

import java.util.ArrayList;

public class FCFS {

    public static void FcfsAlg(ArrayList<Inputs> inputList){

        printList(inputList);

        for(int i = 0; i < inputList.size();i++){
            int id = inputList.get(i).id;
            int time =  WaitTime(inputList, i);
            //TODO construct output
            System.out.println("fcfs wait of p" + id + " = " + time);
        }
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
