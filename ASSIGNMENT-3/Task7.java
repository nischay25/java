import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task7 {
    public static void main(String[] args) throws Exception {
        String[] files = {"85", "92", "CORRUPT", "74", null, "60", "BAD", "99"};
        for (int threads : new int[]{1, 2, 4, 8}) {
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            ConcurrentHashMap<Integer, String> results = new ConcurrentHashMap<>();
            AtomicInteger failed = new AtomicInteger();
            long start = System.nanoTime();
            List<Future<?>> futures = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                final int id = i;
                futures.add(pool.submit((Callable<Void>) () -> {
                    try { results.put(id, Integer.parseInt(files[id]) >= 50 ? "PASS" : "FAIL"); }
                    catch (Exception e) { failed.incrementAndGet(); }
                    return null;
                }));
            }
            for (Future<?> f : futures) f.get();
            pool.shutdown();
            System.out.println("Pool=" + threads + " OK=" + results.size() + " Failed=" + failed.get() + " Time=" + (System.nanoTime() - start) + " ns");
        }
    }
}
