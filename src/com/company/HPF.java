package com.company;

import java.util.ArrayList;

public class HPF {

    public static void HpfAlg(ArrayList<Inputs> inputList){
        // assign sortedInputs the correctly ordered priority values in inputList
        ArrayList<Inputs> sortedInputs = Sorter(inputList);
        printList(sortedInputs);
        Utils.WaitOutput(sortedInputs, "HPF");
        System.out.println();
        System.out.println("                <><> end HPF <><>");
        System.out.println();

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
        System.out.println();
    }

    //sorts the input List based on highest priorities
    public static ArrayList<Inputs> Sorter(ArrayList<Inputs> list ){

        //copying list into tmp list to prevent list from being modified at all
        ArrayList<Inputs> tmpList = new ArrayList();
        for(int i = 0; i< list.size();i++){
            tmpList.add(list.get(i));
        }

        for (int i = 0; i < tmpList.size(); i++) {

            for (int j = tmpList.size() - 1; j > i; j--) {
                if (tmpList.get(i).priority > tmpList.get(j).priority) {

                    Inputs tmp = new Inputs(tmpList.get(i).id,tmpList.get(i).time,tmpList.get(i).priority) ;
                    tmpList.set(i,tmpList.get(j)) ;
                    tmpList.set(j,tmp);

                }
            }
        }
        return tmpList;
    }
}
