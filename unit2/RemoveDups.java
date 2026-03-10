public class RemoveDups {

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

    static LinkedList removeNow(LinkedList l) {

        Node current = l.head;

        while (current != null && current.next != null) {

            if (current.data == current.next.data) {
                current.next = current.next.next;
                l.length--;
            } else {
                current = current.next;
            }
        }

        return l;
    }

    public static void main(String... args) {

        LinkedList list = new LinkedList(1);
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);

        System.out.println("Before:");
        list.printList();

        removeNow(list);

        System.out.println("After removing duplicates:");
        list.printList();
    }
}
