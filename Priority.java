import java.util.*;

public class Priority {
    public static void main(String[] args) {
      System.out.println("*** Priority Scdefuling ***");
      System.out.println("Enter number of process: ");
      Scanner sc=new Scanner(System.in);
      int nofpro=sc.nextInt();
      String process[]=new String[nofpro];
      int p=1;
      for (int i=0; i<nofpro; i++){
        process[i]="P"+p; p++;
      } 
      System.out.println(Arrays.toString(process));
      System.out.print("Enter burst Time for "+nofpro+"process: ");
      
      int burstTime[]=new int[nofpro];
      for (int i=0; i<nofpro; i++){ burstTime[i]=sc.nextInt();}
      System.out.println(Arrays.toString(burstTime));
      System.out.print("Enter priority for "+nofpro+" process: ");

      int priority[]=new int[nofpro];
      for (int i=0;i<nofpro ;i++ ){ priority[i]=sc.nextInt();}
      System.out.println(Arrays.toString(priority));

      int temp;
      String temp2;
      for(int i=0;i<nofpro;i++){
        for(int j=0;j<nofpro;j++){
          if(priority[j]>priority[j+1]){
            temp=priority[j];
            priority[j]=priority[j+1];
            priority[j+1]=temp;
            temp=burstTime[j];
            burstTime[j]=burstTime[j+1];
            burstTime[j+1]=temp;
            temp2=process[j];
            process[j]=process[j+1];
            process[j+1]=temp2;

          }
        }
      } 
      int TAT[]=new int[nofpro+1];
      int waitingTime[]=new int[nofpro+1];
      for(int i=0;i<nofpro;i++){
        TAT[i]=burstTime[i]+waitingTime[i];
        waitingTime[i+1]=TAT[i];
      }
      int totalWT=0;
      int totalTAT=0;
      double avgWT,avgTAT;

      System.out.println("Process   BT   WT   TAT");
      for(int i=0;i<nofpro;i++){
        System.out.println(process[i]+"\t"+burstTime[i]+"\t"+waitingTime[i]+"\t"+(TAT[i]));
        totalTAT+=(waitingTime[i]+burstTime[i]);
        totalWT+=waitingTime[i];
      }
      avgWT=totalWT/(double)nofpro;
      avgTAT=totalTAT/(double)nofpro;

      System.out.println("\n AverageWaiting Time: "+avgWT);
      System.out.println("Average Turn Around Time: "+avgTAT);
    }
}
