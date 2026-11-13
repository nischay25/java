import java.util.*;

public class Task7 {
    private final Queue<String>[] queues = new Queue[5];

    public Task7() {
        for (int i = 0; i < 5; i++) queues[i] = new ArrayDeque<>();
    }

    public void admit(String name, int severity) {
        queues[severity - 1].add(name + "(S" + severity + ")");
    }

    public String next() {
        for (int i = 0; i < 5; i++) {
            if (!queues[i].isEmpty()) return queues[i].poll();
        }
        return null;
    }

    public static void main(String[] args) {
        Task7 triage = new Task7();
        triage.admit("Ravi", 3);
        triage.admit("Meena", 1);
        triage.admit("Lata", 2);
        triage.admit("Asha", 5);
        triage.admit("Kumar", 1);
        triage.admit("John", 3);

        String p;
        while ((p = triage.next()) != null) {
            System.out.print(p + " ");
        }
    }
}
