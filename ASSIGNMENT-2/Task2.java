import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        ArrayDeque<String> upNext = new ArrayDeque<>();

        for (int i = 0; i < 10000; i++) {
            arrayList.add("Song" + i);
            linkedList.add("Song" + i);
        }

        long t1 = System.nanoTime();
        arrayList.get(5000);
        long t2 = System.nanoTime();
        linkedList.get(5000);
        long t3 = System.nanoTime();

        upNext.addFirst("PrioritySong");
        upNext.addLast("NextSong");

        System.out.println("ArrayList get: " + (t2 - t1) + " ns");
        System.out.println("LinkedList get: " + (t3 - t2) + " ns");
        System.out.println("UpNext Deque poll: " + upNext.pollFirst());
    }
}
