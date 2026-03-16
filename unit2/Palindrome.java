package com.singlelinkedlist;

import java.util.Stack;

public class Palindrome {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        /* Push elements from first half of linked list onto stack. When fast runner
         * (which is moving at 2x speed) reaches the end of the linked list, then we
         * know we're at the middle. */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle element */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

            /* If values are different, then it's not a palindrome */
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
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
        // Palindrome: 1 -> 2 -> 3 -> 2 -> 1
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        // Not a palindrome: 1 -> 2 -> 3 -> 4 -> 5
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is palindrome: " + isPalindrome(head1));

        System.out.print("List 2: ");
        printList(head2);
        System.out.println("Is palindrome: " + isPalindrome(head2));
    }
}
