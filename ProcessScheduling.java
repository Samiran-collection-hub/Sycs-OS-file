import java.util.*;
public class ProcessScheduling {
    public static void main(String[] args) {
      int n,bt[],wt[],tat[];
      float avgwt=0,avgtat=0;
      
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter total number of process (max 20):");
      n=sc.nextInt();
      bt=new int[n];
      wt=new int[n];
      tat=new int[n];
      
      System.out.println("\nEnter process Burst Time");
      for(int i=0;i<n;i++){
        System.out.println("P["+(i+1)+"]:");
        bt[i]=sc.nextInt();
      }
      wt[0]=0;
      for(int i=0;i<n;i++){
        wt[i]=0;
        for(int j=0;j<i;j++){
          wt[i]+=bt[j];
        }
      }
      for (int i=0; i<n; i++){
        tat[i]=bt[i]+wt[i];
        avgtat+=tat[i];
      } 
      avgtat/=n;
      System.out.println("\nAverage Turnaround Time: "+avgtat);
      for(int i=0;i<n;i++){
        avgwt+=wt[i];
      }
      avgwt/=n;
      System.out.println("\nAverage Waiting Time: "+avgwt);
      System.out.println("Process\tBurst time\tWaiting time\tTurnaround time");
      for(int i=0;i<n;i++){
        System.out.println("P["+(i+1)+"]\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
      }
      sc.close();
    }
}
