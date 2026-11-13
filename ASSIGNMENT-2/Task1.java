public class Task1 {
    public static void main(String[] args) {
        String[] fields = {"PNR: 12345", "Name: Arun", "Coach: B1", "Berth: 24", "Fare: 750"};
        
        long t1 = System.nanoTime();
        String s = "";
        for (String f : fields) s += f + "\n";
        long d1 = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String f : fields) sb.append(f).append("\n");
        long d2 = System.nanoTime() - t2;

        long t3 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (String f : fields) sbf.append(f).append("\n");
        long d3 = System.nanoTime() - t3;

        System.out.println("String (+): " + d1 + " ns");
        System.out.println("StringBuilder: " + d2 + " ns");
        System.out.println("StringBuffer: " + d3 + " ns");
    }
}
