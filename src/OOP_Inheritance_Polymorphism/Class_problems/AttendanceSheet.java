package OOP_Inheritance_Polymorphism.Class_problems;

public class AttendanceSheet {
    private final String[] students;
    private int count;

    public AttendanceSheet(int capacity) {
        students = new String[Math.max(0, capacity)];
        count = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name)) {
            return;
        }

        if (count < students.length) {
            students[count++] = name;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
