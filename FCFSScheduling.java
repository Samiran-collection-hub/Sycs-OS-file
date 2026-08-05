import java.util.*;

public class FCFSScheduling
{
  static void findWaitingTime(int[] processes,int n,int[] burstTime,int[] waitingTime){
    waitingTime[0]=0;
    for(int i=1;i<n;i++){
      waitingTime[i]=burstTime[i-1]+waitingTime[i-1];
    }
  }
  static void findTurnAroundTime(int[] processes,int n,int[] burstTime,int[] waitingTime,int[] turnAroundTime){
    for(int i=0;i<n;i++){
      turnAroundTime[i]=burstTime[i]+waitingTime[i];
    }
  }
  static void findAverageTime(int[] processes,int n,int[] burstTime){
    int[] waitingTime=new int[n];
    int[] turnAroundTime=new int[n];
    int totalWaitingTime=0;
    int totalTurnAroundTime=0;

    findWaitingTime(processes,n,burstTime,waitingTime);
    findTurnAroundTime(processes,n,burstTime,waitingTime,turnAroundTime);
    
    System.out.println("Processe\tBurst Time\tWaiting Time\tTurn Around Time");
    for (int i=0; i<n; i++){
      totalWaitingTime+=waitingTime[i];
      totalTurnAroundTime+=turnAroundTime[i];
      System.out.printf("P%d\t\t%d\t\t%d\t\t%d\n",processes[i],burstTime[i],waitingTime[i],turnAroundTime[i]);
    } 
    
    System.out.printf("\n Average Waiting Time = %.2f\n", (float)totalWaitingTime/n);
    System.out.printf("Average Turn Around Time = %.2f\n", (float)totalTurnAroundTime/n);
  }
  public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the number of processes: ");
    int n=sc.nextInt();

    int[] processes=new int[n];
    int[] burstTime=new int[n];

    for (int i=0; i<n; i++){
      processes[i]=i+1;
      System.out.print("Enter Burst Time for Processe P"+(i+1)+": ");
      burstTime[i]=sc.nextInt();
    } 
    findAverageTime(processes,n,burstTime);
    sc.close();
  }
}
