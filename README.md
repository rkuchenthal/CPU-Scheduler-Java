# CPU-Scheduler-Java
General rules: Create homework, compose specifications or any text by using a common 
document-creation tool, such as Microsoft® Word.

Abstract: Compute the performance data for the schedulers of three Operating Systems. 
Do not get scared! Only the timing for each scheduler is of interest. You measure these data 
by implementing a simple simulator. The simulator measures key performance data, such as 
throughput, wait time, and turn-around time.

One OS is a strict batch system with a non-preemptive First Come First Serve (FCFS)
scheduler. The second OS uses also a non-preemptive, High-Priority First (HPF) scheduler, 
while the third OS uses a preemptive Round Robin (RR) scheduler with a variable timequantum and varying context switch overhead. Design meaningful input data, run them 
through all schedulers, generate output data, interpret and discuss the results. To start your 
simulations, use the sample data in this HW assignment; but also provide 2 additional,
meaningful input scenarios, and generate their execution schedules.

Detail: Your HomeWork consists of the following parts with equal weight each:
Compute performance data for the scheduler of a non-preemptive FCFS batch system
Ditto for a non-preemptive HPF batch system, and
Ditto for a preemptive RR scheduler; vary also the time quantum overhead
Invent meaningful input data; run them through your schedulers to produce output
Discuss very briefly the generated output data. Hand all your work in printed form

Turn in only your inputs and the generated output data. There is no need to turn in the actual 
source program that computed and printed the output. But you must have completely 
designed, implemented, debugged, and the executed your simulator.

Input to each scheduler is a list of processes, for which you know the execution time in 
milliseconds. Each process is represented by a triple of decimal numbers id, time, priority. All 
processes are scheduled and compete for the CPU resource. Here id is the name of a process; 
time is the time in milliseconds that process id needs to run to completion, and priority is the 
priority of process id. Not all triple information is needed by all simulations. A possible input 
sample for two processes with id 1 and id 4 could be:
 id time priority
1 2 3
4 50 6

Depending on the scheduler, the priority may be irrelevant; in that case your simulator just 
ignores that portion of input. The meaning of triples is as follows:

1 2 3 process 1 uses 2 milliseconds to run, has priority 3, with priority 0 being highest
4 50 6 process 4 uses 50 milliseconds, has priority 6, with 0 being the highest

Use the definitions below to compute for each process Throughput, Wait Time, and Turnaround Time. Compute these for each of the 3 schedulers; also compute the average for all 
processes.

For the preemptive RR scheduler, vary the time quantum q from 1 to 5 milliseconds (ms). 
Also, for each q selected, vary the overhead o of a context switch from 0 ms up to q itself. 

There is no need to vary the o beyond q. When a process scheduled by the RR system has 
received all time needed to completion, do not add a final o unit in the computation of the total 
time for that process. Also the first time around, act as if the initial schedule overhead o is 0.
Use the sample outputs below as a guide for the detail you should generate for this HW.

Definitions:
Throughput: Number of jobs (processes) completed per time unit
Wait Time: The total time a process is in Ready Queue
Average Wait Time: Average Wait Time of n processes is: total wait time by n
Turn-around Time: span of time from moment of submission to completion time
 
Example 1:
Enter triples: process id, time in ms, and priority: <- 8 lines of prompt
For example:
1 12 0
3 9 1
2 99 9
process 1 needs 12 ms and has priority 0, very high,
process 3 needs 9 ms and has priority 1.
and so on ...
1 2 3 <- this is user input
2 1 2
Process list in FCFS order as entered: <- start of simulator output
1 2 3 
2 1 2 
End of list.
fcfs wait of p1 = 0
fcfs wait of p2 = 2
average wait for 2 procs = 1
fcfs turn-around time for p1 = 2
fcfs turn-around time for p2 = 3
average turn-around for 2 procs = 2.5
fcfs throughput for 2 procs = 0.666667 proc/ms

<><> end FCFS <><>

Process list in HPF order:
2 1 2 
1 2 3 
End of list.
hpf wait of p2 = 0
hpf wait of p1 = 1
average wait time for 2 procs = 0.5
hpf turn-around for p2 = 1
hpf turn-around for p1 = 3
average turn-around for 2 procs = 2
hpf throughput for 2 procs = 0.666667 proc/ms

<><> end HPF schedule <><>

Process list for RR in order entered: 
1 2 3 
2 1 2 
preemptive RR schedule, quantum = 1 overhead = 0
RR TA time for finished p2 = 2, needed: 1 ms, and: 1 time slices.
RR TA time for finished p1 = 3, needed: 2 ms, and: 2 time slices.
RR Throughput, 2 p, with q: 1, o: 0, is: 0.666667 p/ms, or 666.667 p/us
Average RR TA, 2 p, with q: 1, o: 0, is: 2.5

preemptive RR schedule, quantum = 1 overhead = 1
RR TA time for finished p2 = 3, needed: 1 ms, and: 1 time slices.
RR TA time for finished p1 = 5, needed: 2 ms, and: 2 time slices.
RR Throughput, 2 p, with q: 1, o: 1, is: 0.4 p/ms, or 400 p/us
Average RR TA, 2 p, with q: 1, o: 1, is: 4

preemptive RR schedule, quantum = 2 overhead = 0
RR TA time for finished p1 = 2, needed: 2 ms, and: 1 time slices.
RR TA time for finished p2 = 3, needed: 1 ms, and: 1 time slices.
RR Throughput, 2 p, with q: 2, o: 0, is: 0.666667 p/ms, or 666.667 p/us
Average RR TA, 2 p, with q: 2, o: 0, is: 2.5

preemptive RR schedule, quantum = 2 overhead = 1
RR TA time for finished p1 = 2, needed: 2 ms, and: 1 time slices.
RR TA time for finished p2 = 4, needed: 1 ms, and: 1 time slices.
RR Throughput, 2 p, with q: 2, o: 1, is: 0.5 p/ms, or 500 p/us
Average RR TA, 2 p, with q: 2, o: 1, is: 3

preemptive RR schedule, quantum = 2 overhead = 2
RR TA time for finished p1 = 2, needed: 2 ms, and: 1 time slices.
RR TA time for finished p2 = 5, needed: 1 ms, and: 1 time slices.
RR Throughput, 2 p, with q: 2, o: 2, is: 0.4 p/ms, or 400 p/us
Average RR TA, 2 p, with q: 2, o: 2, is: 3.5

<><> end preemptive RR schedule <><>

Example 2:
Enter triples: process id, time in ms, and priority:
For example:
1 12 0
3 9 1
2 99 9
process 1 needs 12 ms and has priority 0, very high,
process 3 needs 9 ms and has priority 1.
and so on ...
1 10 5 <- this is user input
2 8 1 
3 12 7 
Process list in FCFS order as entered:
1 10 5 
2 8 1 
3 12 7 
End of list.
fcfs wait of p1 = 0
fcfs wait of p2 = 10
fcfs wait of p3 = 18
average wait for 3 procs = 9.33333
fcfs turn-around time for p1 = 10
fcfs turn-around time for p2 = 18
fcfs turn-around time for p3 = 30
average turn-around for 3 procs = 19.3333
fcfs throughput for 3 procs = 0.1 proc/ms

<><> end FCFS <><>

Process list in HPF order:
2 8 1 
1 10 5 
3 12 7 
End of list.
hpf wait of p2 = 0
hpf wait of p1 = 8
hpf wait of p3 = 18
average wait time for 3 procs = 8.66667
hpf turn-around for p2 = 8
hpf turn-around for p1 = 18
hpf turn-around for p3 = 30
average turn-around for 3 procs = 18.6667
hpf throughput for 3 procs = 0.1 proc/ms

<><> end HPF schedule <><>

Process list for RR in order entered: 
1 10 5 
2 8 1 
3 12 7 
End of list.

preemptive RR schedule, quantum = 1 overhead = 0
RR TA time for finished p2 = 23, needed: 8 ms, and: 8 time slices.
RR TA time for finished p1 = 27, needed: 10 ms, and: 10 time slices.
RR TA time for finished p3 = 30, needed: 12 ms, and: 12 time slices.
RR Throughput, 3 p, with q: 1, o: 0, is: 0.1 p/ms, or 100 p/us
Average RR TA, 3 p, with q: 1, o: 0, is: 26.6667

preemptive RR schedule, quantum = 1 overhead = 1
RR TA time for finished p2 = 45, needed: 8 ms, and: 8 time slices.
RR TA time for finished p1 = 53, needed: 10 ms, and: 10 time slices.
RR TA time for finished p3 = 59, needed: 12 ms, and: 12 time slices.
RR Throughput, 3 p, with q: 1, o: 1, is: 0.0508475 p/ms, or 50.8475 p/us
Average RR TA, 3 p, with q: 1, o: 1, is: 52.3333

preemptive RR schedule, quantum = 2 overhead = 0
RR TA time for finished p2 = 22, needed: 8 ms, and: 4 time slices.
RR TA time for finished p1 = 26, needed: 10 ms, and: 5 time slices.
RR TA time for finished p3 = 30, needed: 12 ms, and: 6 time slices.
RR Throughput, 3 p, with q: 2, o: 0, is: 0.1 p/ms, or 100 p/us
Average RR TA, 3 p, with q: 2, o: 0, is: 26

preemptive RR schedule, quantum = 2 overhead = 1
RR TA time for finished p2 = 32, needed: 8 ms, and: 4 time slices.
RR TA time for finished p1 = 38, needed: 10 ms, and: 5 time slices.
RR TA time for finished p3 = 44, needed: 12 ms, and: 6 time slices.
RR Throughput, 3 p, with q: 2, o: 1, is: 0.0681818 p/ms, or 68.1818 p/us
Average RR TA, 3 p, with q: 2, o: 1, is: 38

preemptive RR schedule, quantum = 2 overhead = 2
RR TA time for finished p2 = 42, needed: 8 ms, and: 4 time slices.
RR TA time for finished p1 = 50, needed: 10 ms, and: 5 time slices.
RR TA time for finished p3 = 58, needed: 12 ms, and: 6 time slices.
RR Throughput, 3 p, with q: 2, o: 2, is: 0.0517241 p/ms, or 51.7241 p/us
Average RR TA, 3 p, with q: 2, o: 2, is: 50

preemptive RR schedule, quantum = 3 overhead = 0
RR TA time for finished p2 = 23, needed: 8 ms, and: 3 time slices.
RR TA time for finished p1 = 27, needed: 10 ms, and: 4 time slices.
RR TA time for finished p3 = 30, needed: 12 ms, and: 4 time slices.
RR Throughput, 3 p, with q: 3, o: 0, is: 0.1 p/ms, or 100 p/us
Average RR TA, 3 p, with q: 3, o: 0, is: 26.6667

preemptive RR schedule, quantum = 3 overhead = 1
RR TA time for finished p2 = 30, needed: 8 ms, and: 3 time slices.
RR TA time for finished p1 = 36, needed: 10 ms, and: 4 time slices.
RR TA time for finished p3 = 40, needed: 12 ms, and: 4 time slices.
RR Throughput, 3 p, with q: 3, o: 1, is: 0.075 p/ms, or 75 p/us
Average RR TA, 3 p, with q: 3, o: 1, is: 35.3333

preemptive RR schedule, quantum = 3 overhead = 2
RR TA time for finished p2 = 37, needed: 8 ms, and: 3 time slices.
RR TA time for finished p1 = 45, needed: 10 ms, and: 4 time slices.
RR TA time for finished p3 = 50, needed: 12 ms, and: 4 time slices.
RR Throughput, 3 p, with q: 3, o: 2, is: 0.06 p/ms, or 60 p/us
Average RR TA, 3 p, with q: 3, o: 2, is: 44

preemptive RR schedule, quantum = 3 overhead = 3
RR TA time for finished p2 = 44, needed: 8 ms, and: 3 time slices.
RR TA time for finished p1 = 54, needed: 10 ms, and: 4 time slices.
RR TA time for finished p3 = 60, needed: 12 ms, and: 4 time slices.
RR Throughput, 3 p, with q: 3, o: 3, is: 0.05 p/ms, or 50 p/us
Average RR TA, 3 p, with q: 3, o: 3, is: 52.6667

preemptive RR schedule, quantum = 4 overhead = 0
RR TA time for finished p2 = 20, needed: 8 ms, and: 2 time slices.
RR TA time for finished p1 = 26, needed: 10 ms, and: 3 time slices.
RR TA time for finished p3 = 30, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 4, o: 0, is: 0.1 p/ms, or 100 p/us
Average RR TA, 3 p, with q: 4, o: 0, is: 25.3333

preemptive RR schedule, quantum = 4 overhead = 1
RR TA time for finished p2 = 24, needed: 8 ms, and: 2 time slices.
RR TA time for finished p1 = 32, needed: 10 ms, and: 3 time slices.
RR TA time for finished p3 = 37, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 4, o: 1, is: 0.0810811 p/ms, or 81.0811 p/us
Average RR TA, 3 p, with q: 4, o: 1, is: 31

preemptive RR schedule, quantum = 4 overhead = 2
RR TA time for finished p2 = 28, needed: 8 ms, and: 2 time slices.
RR TA time for finished p1 = 38, needed: 10 ms, and: 3 time slices.
RR TA time for finished p3 = 44, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 4, o: 2, is: 0.0681818 p/ms, or 68.1818 p/us
Average RR TA, 3 p, with q: 4, o: 2, is: 36.6667

preemptive RR schedule, quantum = 4 overhead = 3
RR TA time for finished p2 = 32, needed: 8 ms, and: 2 time slices.
RR TA time for finished p1 = 44, needed: 10 ms, and: 3 time slices.
RR TA time for finished p3 = 51, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 4, o: 3, is: 0.0588235 p/ms, or 58.8235 p/us
Average RR TA, 3 p, with q: 4, o: 3, is: 42.3333

preemptive RR schedule, quantum = 4 overhead = 4
RR TA time for finished p2 = 36, needed: 8 ms, and: 2 time slices.
RR TA time for finished p1 = 50, needed: 10 ms, and: 3 time slices.
RR TA time for finished p3 = 58, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 4, o: 4, is: 0.0517241 p/ms, or 51.7241 p/us
Average RR TA, 3 p, with q: 4, o: 4, is: 48

preemptive RR schedule, quantum = 5 overhead = 0
RR TA time for finished p1 = 20, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 23, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 30, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 0, is: 0.1 p/ms, or 100 p/us
Average RR TA, 3 p, with q: 5, o: 0, is: 24.3333

preemptive RR schedule, quantum = 5 overhead = 1
RR TA time for finished p1 = 23, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 27, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 36, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 1, is: 0.0833333 p/ms, or 83.3333 p/us
Average RR TA, 3 p, with q: 5, o: 1, is: 28.6667

preemptive RR schedule, quantum = 5 overhead = 2
RR TA time for finished p1 = 26, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 31, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 42, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 2, is: 0.0714286 p/ms, or 71.4286 p/us
Average RR TA, 3 p, with q: 5, o: 2, is: 33

preemptive RR schedule, quantum = 5 overhead = 3
RR TA time for finished p1 = 29, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 35, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 48, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 3, is: 0.0625 p/ms, or 62.5 p/us
Average RR TA, 3 p, with q: 5, o: 3, is: 37.3333

preemptive RR schedule, quantum = 5 overhead = 4
RR TA time for finished p1 = 32, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 39, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 54, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 4, is: 0.0555556 p/ms, or 55.5556 p/us
Average RR TA, 3 p, with q: 5, o: 4, is: 41.6667

preemptive RR schedule, quantum = 5 overhead = 5
RR TA time for finished p1 = 35, needed: 10 ms, and: 2 time slices.
RR TA time for finished p2 = 43, needed: 8 ms, and: 2 time slices.
RR TA time for finished p3 = 60, needed: 12 ms, and: 3 time slices.
RR Throughput, 3 p, with q: 5, o: 5, is: 0.05 p/ms, or 50 p/us
Average RR TA, 3 p, with q: 5, o: 5, is: 46

<><> end preemptive RR schedule <><>
