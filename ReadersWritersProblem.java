import java.util.concurrent.*;

public class ReadersWritersProblem{
  private final Semaphore readLock=new Semaphore(1);
  private final Semaphore writeLock=new Semaphore(1);
  private int readerCount=0;

  public void startReading() throws InterruptedException
  {
    readLock.acquire();
    synchronized(this)
    {
      readerCount++;
      if (readerCount==0){writeLock.acquire();} 
    }
    readLock.release();
    System.out.println(Thread.currentThread().getName()+" start reading.");
  }
  public void stopReading() throws InterruptedException
  {
    readLock.acquire();
    synchronized(this)
    {
      readerCount--;
      if (readerCount==0){writeLock.release();}
    }
    readLock.release();
    System.out.println(Thread.currentThread().getName()+" stopped reading.");
  }
  
  public void startWriting() throws InterruptedException
  {
    writeLock.acquire();
    System.out.println(Thread.currentThread().getName()+" start writing.");
  }
  public void stopwriting()
  {
    writeLock.release();
    System.out.println(Thread.currentThread().getName()+" stopped writing.");
  }
  public static void main (String[] args) {
    ReadersWritersProblem rw=new ReadersWritersProblem();
    for (int i=0; i<5; i++)
    {
      new Thread(()->{
        try {
         rw.startReading();
        Thread.sleep(1000);
        rw.stopReading(); 
        } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      },"Reader-"+(i+1)).start();
    } 
    new Thread(()->{
      try {
        rw.startWriting();
        Thread.sleep(2000);
        rw.stopwriting();
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    },"Writer-1").start();
  }
}
