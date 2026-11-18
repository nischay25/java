import java.io.*;

public class Task1 {
    static void withdraw(String input, int bal, String file) {
        try {
            new FileInputStream(file).close();
            int amt = Integer.parseInt(input);
            if (amt <= 0) throw new ArithmeticException("Negative amount");
            if (amt > bal) throw new IllegalStateException("Insufficient balance");
            System.out.println("Dispensed: " + amt + ", Balance: " + (bal - amt));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Card Missing: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ATM Error: " + e.getMessage());
        } finally {
            System.out.println("Session closed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new FileOutputStream("card.txt").close();
        for (String a : new String[]{"500", "abc", "-50", "1500"}) withdraw(a, 1000, "card.txt");
        withdraw("200", 1000, "missing.txt");
    }
}
