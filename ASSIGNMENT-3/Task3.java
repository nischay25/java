import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        try (PrintWriter w1 = new PrintWriter("s1.txt"); PrintWriter w2 = new PrintWriter("s2.txt")) {
            w1.println("1500");
            w2.println("2500");
        }
        int total = 0;
        try (PrintWriter out = new PrintWriter("summary.txt")) {
            for (String f : new String[]{"s1.txt", "s2.txt", "missing.txt"}) {
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    total += Integer.parseInt(br.readLine().trim());
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Failed on " + f + ": " + e.getMessage());
                }
            }
            out.println("Total Sales: " + total);
            System.out.println("Total Sales: " + total);
        }
    }
}
