package DSA_Revision.Class_problems;

import java.util.*;

class LibraryDesk {
    static String[] stack = new String[3];
    static int top = -1;

    static String[] queue = new String[3];
    static int front = 0, rear = -1, size = 0;

    static void returnBook(String book) {
        if (top == 2) {
            System.out.println(book + " rejected: pile is full");
            return;
        }

        stack[++top] = book;
        System.out.println(book + " placed on pile");
    }

    static void shelve() {
        if (top == -1) {
            System.out.println("pile is empty");
            return;
        }

        System.out.println("shelved " + stack[top--]);
    }

    static void waitStudent(String name) {
        if (size == 3) {
            System.out.println(name + " rejected: line is full");
            return;
        }

        rear = (rear + 1) % 3;
        queue[rear] = name;
        size++;

        System.out.println(name + " joined the line");
    }

    static void serve() {
        if (size == 0) {
            System.out.println("no one waiting");
            return;
        }

        System.out.println("served " + queue[front]);
        front = (front + 1) % 3;
        size--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "RETURN":
                    returnBook(sc.next());
                    break;
                case "SHELVE":
                    shelve();
                    break;
                case "WAIT":
                    waitStudent(sc.next());
                    break;
                case "SERVE":
                    serve();
                    break;
            }
        }
    }
}

