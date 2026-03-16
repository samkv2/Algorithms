package com.singlelinkedlist;

public class DeleteMiddleNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false; // Failure
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        Node middle = new Node(3);
        head.next.next = middle;
        middle.next = new Node(4);
        middle.next.next = new Node(5);

        System.out.println("Before deleting middle node (3):");
        printList(head);

        deleteNode(middle);

        System.out.println("After deleting middle node:");
        printList(head);
    }
}
