class TicketBooking implements Runnable {

    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of bookingThread while mainThread is waiting: "
                + TicketSystem.mainThread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TicketSystem implements Runnable {

    public static Thread mainThread;
    public static TicketSystem ticketSystem;

    public void run() {

        TicketBooking booking = new TicketBooking();

        // Create booking thread
        Thread bookingThread = new Thread(booking);

        System.out.println("State after creating bookingThread: "
                + bookingThread.getState());

        bookingThread.start();

        System.out.println("State after starting bookingThread: "
                + bookingThread.getState());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after sleeping bookingThread: "
                + bookingThread.getState());

        try {
            bookingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after bookingThread finishes: "
                + bookingThread.getState());
    }

    public static void main(String[] args) {

        ticketSystem = new TicketSystem();

        mainThread = new Thread(ticketSystem);

        System.out.println("State after creating mainThread: "
                + mainThread.getState());

        mainThread.start();

        System.out.println("State after starting mainThread: "
                + mainThread.getState());
    }
}
