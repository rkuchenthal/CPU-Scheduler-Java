package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Parser {
    public static void InputPrompt(){
        //Output that shows how to format user input of task with id,time, and priority
        System.out.print("Enter triples: process id, time in ms, and priority:\n" +
                "For example:\n" +
                "1 12 0\n" +
                "3 9 1\n" +
                "2 99 9\n" +
                "process 1 needs 12 ms and has priority 0, very high,\n" +
                "process 3 needs 9 ms and has priority 1.\n" +
                "and so on ... Input below:\n");
    }

    public static ArrayList<Inputs> InputParser()throws Exception{
        // initialize all variables and lists
        ArrayList<Inputs> inputs = new ArrayList();
        String line;
        String[] inputLine;

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
        return inputs;
    }
}
