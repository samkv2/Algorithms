public class LoopDetection {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;

        LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        }

        void append(int value) {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }

       
        void createLoop(int position) {
            Node temp = head;
            Node loopNode = null;
            int index = 0;

            while (temp != null) {
                if (index == position) {
                    loopNode = temp;
                }
                if (temp.next == null) {
                    temp.next = loopNode;
                    return;
                }
                temp = temp.next;
                index++;
            }
        }
    }

    static boolean detectLoop(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;   

            if (slow == fast) {
                return true;         
            }
        }

        return false;       
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        list.createLoop(2); 

        if (detectLoop(list)) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
    }
}
