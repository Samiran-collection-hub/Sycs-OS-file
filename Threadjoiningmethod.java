import java.io.*;
import java.util.*;

public class Threadjoiningmethod extends Thread{
  public void run(){
    for (int i=1; i<5; i++){
      try {Thread.sleep(500);} 
      catch(Exception e) {System.out.println(e);}
      System.out.println(i);
    } 
  }
  public static void main (String[] args) {
    Threadjoiningmethod th1 = new Threadjoiningmethod();
    Threadjoiningmethod th2 = new Threadjoiningmethod();
    Threadjoiningmethod th3 = new Threadjoiningmethod();
    Threadjoiningmethod th4 = new Threadjoiningmethod();

    th1.start();
    try{th1.join();}
    catch(Exception e){System.out.println(e);}

    th2.start();
    try{th2.join();}
    catch(Exception e){System.out.println(e);}

    th3.start();
    try{th3.join();}
    catch(Exception e){System.out.println(e);}

    th4.start();
    try{th4.join();}
    catch(Exception e){System.out.println(e);}
  }
}
