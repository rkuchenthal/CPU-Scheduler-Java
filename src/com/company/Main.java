package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Parser.InputPrompt();
        ArrayList<Inputs> inputs = Parser.InputParser();

        //Now call all 3 schedulers 1 after another each using the inputs ArrayList<>
        // and have them all print the results once their done and before the next one starts

        //First Come First Serve
        FCFS.FcfsAlg(inputs);
        //High Priority First
        HPF.HpfAlg(inputs);
        //Round Robin
        RR.RrAlg(inputs);

    }
}
