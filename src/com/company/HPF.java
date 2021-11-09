package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class HPF {



    public static void HpfAlg(ArrayList<Inputs> inputList){

        // assign sortedInputs the correctly ordered priority values in inputList
        ArrayList<Inputs> sortedInputs = Sorter(inputList);

        printList(sortedInputs);
        Utils.WaitOutput(sortedInputs, "HPF");
        //TODO print throughput
        System.out.println("                <><> end HPF <><>");
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

    //sorts the input List based on highest priorities
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
}
