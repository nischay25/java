class StationThread extends Thread {
    public void run() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println(getName() + " (Thread) scanned 25 scripts");
    }
}

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " (Runnable) scanned 25 scripts");
        };
        Thread[] s = {new StationThread(), new StationThread(), new Thread(task, "Station-3"), new Thread(task, "Station-4")};
        for (Thread t : s) t.start();
        System.out.println("Station-1 alive: " + s[0].isAlive());
        for (Thread t : s) t.join();
        System.out.println("All 4 stations done. Total: 100 scripts");
    }
}
