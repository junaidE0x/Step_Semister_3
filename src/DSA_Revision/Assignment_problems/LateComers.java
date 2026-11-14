package DSA_Revision.Assignment_problems;

import java.util.*;

class LateComers {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node addFirst(Node head, String name) {
        Node n = new Node(name);
        n.next = head;
        return n;
    }

    static Node addLast(Node head, String name) {
        Node n = new Node(name);

        if (head == null)
            return n;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = n;
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
        Node head = null;

        for (int i = 0; i < n; i++)
            head = addLast(head, sc.next());

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String operation = sc.next();
            String name = sc.next();

            if (operation.equals("addFirst"))
                head = addFirst(head, name);
            else if (operation.equals("addLast"))
                head = addLast(head, name);
        }

        print(head);
    }
}

