package com.singlelinkedlist;

public class Intersection {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Result {
        public Node tail;
        public int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        /* Get tail and sizes. */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size < result2.size ? list2 : list1;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one. */
        return longer;
    }

    private static Result getTailAndSize(Node list) {
        if (list == null) return null;

        int size = 1;
        Node current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    private static Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
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
        // Common part: 7 -> 2 -> 1
        Node common = new Node(7);
        common.next = new Node(2);
        common.next.next = new Node(1);

        // List 1: 3 -> 1 -> 5 -> [7 -> 2 -> 1]
        Node head1 = new Node(3);
        head1.next = new Node(1);
        head1.next.next = new Node(5);
        head1.next.next.next = common;

        // List 2: 4 -> 6 -> [7 -> 2 -> 1]
        Node head2 = new Node(4);
        head2.next = new Node(6);
        head2.next.next = common;

        System.out.print("List 1: ");
        printList(head1);
        System.out.print("List 2: ");
        printList(head2);

        Node intersection = findIntersection(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection at node with data: " + intersection.data);
        } else {
            System.out.println("No intersection.");
        }
    }
}
