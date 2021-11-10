package com.company;

import java.util.ArrayList;

public class RR {
    public static void RrAlg(ArrayList<Inputs> inputList){
        printList(inputList);
        //todo create round robin arraylists and cycle them per time slices
        //todo calculate
        TaTime(inputList, 1, 0);
        //todo
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
        System.out.println("");
    }

    public static void TaTime(ArrayList<Inputs> list, int q, int o){
        ArrayList<Inputs> tmp = new ArrayList();

        for(int i =0; i < list.size();i++){

        }
    }

}
