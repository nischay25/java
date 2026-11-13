import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedMap = new LinkedHashMap<>();

        String[][] meds = {{"MED103", "50"}, {"MED101", "20"}, {"MED102", "35"}};
        for (String[] m : meds) {
            int qty = Integer.parseInt(m[1]);
            hashMap.put(m[0], qty);
            treeMap.put(m[0], qty);
            linkedMap.put(m[0], qty);
        }

        System.out.println("Lookup MED101: " + hashMap.get("MED101"));
        System.out.println("Code Order (TreeMap): " + treeMap);
        System.out.println("Added Order (LinkedHashMap): " + linkedMap);
    }
}
