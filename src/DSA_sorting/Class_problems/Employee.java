package DSA_sorting.Class_problems;

import java.util.*;

class Employee {
    static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> map = new HashMap<>();

        for (String[] record : records)
            map.put(record[0], record[1]);

        return map;
    }

    static String getDepartment(HashMap<String, String> map, String id) {
        return map.getOrDefault(id, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
                {"E245", "Finance"},
                {"E110", "Engineering"},
                {"E390", "Marketing"},
                {"E101", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}

