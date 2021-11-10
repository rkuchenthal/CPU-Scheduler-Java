package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
	    // initialize all variables and lists
        ArrayList<Inputs> inputs = new ArrayList();
        String line;
        String[] inputLine;

        //Output that shows how to format user input of task with id,time, and priority
        System.out.print("Enter triples: process id, time in ms, and priority:\n" +
                "For example:\n" +
                "1 12 0\n" +
                "3 9 1\n" +
                "2 99 9\n" +
                "process 1 needs 12 ms and has priority 0, very high,\n" +
                "process 3 needs 9 ms and has priority 1.\n" +
                "and so on ... Input below:\n");

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        while(!(line = br.readLine()).equals("")){

            //validate all inputs are integers
            try{
                //turns "1 2 3" -> arr[0 ="1", 1 ="2", 2 ="3"]
                inputLine = line.split(" ");

                Inputs newInput = new Inputs(Integer.parseInt(inputLine[0]),
                                             Integer.parseInt(inputLine[1]),
                                             Integer.parseInt(inputLine[2]));
                //Now add the line of input to the inputs arraylist
                inputs.add(newInput);

            }catch (Exception e){
                System.out.println(e);
                System.out.println("Input not acceptable, 3 Integers separated by spaces only.");
           }

        }


        //Now call all 3 schedulers 1 after another each using the inputs ArrayList<>
        // and have them all print the results once their done and before the next one starts

        //First Come First Serve
        FCFS.FcfsAlg(inputs);
        //High Priority First
        HPF.HpfAlg(inputs);
        //Round Robin
        //RR.RrAlg(inputs);

    }
}
