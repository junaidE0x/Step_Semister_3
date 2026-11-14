package DSA_Revision.Assignment_problems;

import java.util.*;

class BusRoute {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] stops) {
        Node head = null, tail = null;

        for (String stop : stops) {
            Node n = new Node(stop);

            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        return head;
    }

    static void printRoute(Node head) {
        Node temp = head;
        int count = 0;
        String last = "";

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            last = temp.data;
            count++;
            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " +
                head.data + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++)
            stops[i] = sc.next();

        Node head = build(stops);
        printRoute(head);
    }
}

