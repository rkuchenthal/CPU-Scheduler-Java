package com.company;

import java.util.ArrayList;

public class FCFS {

    public static void FcfsAlg(ArrayList<Inputs> inputList){

        printList(inputList);
        Utils.WaitOutput(inputList, "FCFS");
        //TODO print throughput
        System.out.println("                <><> end FCFS <><>");

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
