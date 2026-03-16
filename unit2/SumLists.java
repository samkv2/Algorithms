package com.singlelinkedlist;

public class SumLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(0);
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next,
                                 l2 == null ? null : l2.next,
                                 value >= 10 ? 1 : 0);
            result.next = more;
        }

        return result;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List 1: 7 -> 1 -> 6 (617)
        Node l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);

        // List 2: 5 -> 9 -> 2 (295)
        Node l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);

        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        Node result = addLists(l1, l2, 0);

        System.out.print("Sum: ");
        printList(result);
        System.out.println("(Expected: 2 -> 1 -> 9)");
    }
}
