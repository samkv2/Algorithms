public class ReturnKthFromLast{
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
	
	public static void main(String ...args){

	LinkedList mylist=new LinkedList(1);
	for(int i=2;i<=5;i++){
		mylist.append(i);
	}
	System.out.println("---------here is the Linked list of 5 elements-----");
	mylist.printList();
    int k=3;
	Node result = KthFromLast(mylist, k);
	System.out.println(k+"th from last: " + result.data);
		
	}

	static Node KthFromLast(LinkedList mylist, int k){
	    Node slow = mylist.head;
	    Node fast = mylist.head;
	
	    if(mylist.length == 0) return null;
	
	    for(int i = 0; i < k; i++){
	        if(fast == null) return null;
	        fast = fast.next;
	    }
	
	    while(fast != null){
	        slow = slow.next;
	        fast = fast.next;
	    }
	
	    return slow;
	}
	
}
