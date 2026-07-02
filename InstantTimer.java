import java.time.*;

public class InstantTimer{
  public static void methodToBeTimed(){
    try {Thread.sleep(1500);} 
    catch(Exception e) {Thread.currentThread().interrupt();}
  }
  public static void main (String[] args) {
    Instant start = Instant.now();
    methodToBeTimed();
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    System.out.println("Execution time: "+timeElapsed.toMillis()+"ms");
  }
}
