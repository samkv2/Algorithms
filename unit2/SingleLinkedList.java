package com.singlelinkedlist;

public class SingleLinkedList{

		static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int length;

        LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        void append(int value) {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            length++;
        }

        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    	
}
}
