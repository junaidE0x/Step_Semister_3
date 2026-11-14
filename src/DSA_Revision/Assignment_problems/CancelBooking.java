package DSA_Revision.Assignment_problems;

import java.util.*;

class CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null)
            return null;

        if (head.data.equals(booking))
            return head.next;

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.equals(booking)) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.next());

            if (head == null)
                head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        String booking = sc.next();
        head = removeFirst(head, booking);
        print(head);
    }
}

