
public class LinkedList {
	
	Node head; // head of the list
	
	class Node {
		int data;
		Node next;
		
		// constructor to create a new node
		Node(int new_data) {
			this.data = new_data;
			this.next = null;
		} 
	}
	
	/**
	 *  A node can be added in three ways in LinkedList
	 *   	1) At the front of the linked list
	 *		2) After a given node.
	 *		3) At the end of the linked list.
	 */
	
	// The push() must receive a pointer to the head pointer, because push must change the head pointer to point to the new node.
	// Works as a Stack ( LIFO -> Last in first out )
	public void pushFront(int new_data) {
		if(head == null) {
			head = new Node(new_data);
		}
		// 1. Make a new node
		Node node = new Node(new_data);
		
		// 2. Make next of new_node as head
		node.next = head;
		
		// 3. Move the head to point to the new_node
		head = node;
	}
	
	/* 
	   Inserts a new node after the given prev_node. This method is  
	   defined inside LinkedList class shown above 
	*/
	public void insertAfter(Node prev_node, int new_data) {
		
		// 1. Check if the given Node is null
		if(prev_node == null) {
			System.out.println("The given previous node can not be null");
			return;
		}
		
		// 2. make a new Node
		Node new_node = new Node(new_data);
		
		// 3. Make next of new_node as next of prev_node
		new_node.next = prev_node.next;
		
		// 4. Make next of prev_node as new_node
		prev_node.next = new_node;
	}
	
	// works as QUEUE ( FIFO -> First in First Out)
	public void append(int new_data) {
		
		/* 1. Make a Node with data */
		Node new_node = new Node(new_data);
		
		/* 2. if Linkedlist is empty then make new_node as head */
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		
		/* 3. Make a new_node's next as null */
		new_node.next = null;
		
		/* 4. Traverse till the last node  */
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		/* 5. Make next of last_node as new_node */
		last.next = new_node;
		return;
	}
	
	public int remove() {
		Node temp = head;
		
		if(head == null) {
			return -1;
		}
		int data = temp.data;
		head = temp.next;
		return data;
	}
	
	public void deleteNode(int key) {
		
		Node temp = head;
		Node prev = null;
		
		//1. if key is head, delete head
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		//2. else find a previous node of a node to be deleted
		while(temp.next != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		// 3. if key is not present in linekedList
		if (temp == null) return; 
		
		prev.next = temp.next;
	}
	
	// get a size of linkedList
	public int getSize() {
		int counter = 0;
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}
	
	
	// delete a node at given position
	public void deleteAtPosition(int pos) {
		if (head == null) {
			return;
		}		
		
		if(pos == 0) {
			head = head.next;
			return;
		}
		Node temp = head;
		//find a previous node of node to be deleted
		for(int i = 1; temp.next != null && i == pos; i++) {
			temp = temp.next;
		}
		
		if(temp == null || temp.next == null) {
			System.out.println("given position is more than size!");
			return;
		}
		
		temp.next = temp.next.next;
	}
	
	// search a node
	Node searchNode(int key) {
		Node temp = head;
		
		while(temp != null && temp.data != key) {
			temp = temp.next;
		}
		
		temp = temp.next;
		return temp;
	}
	
	public void printLinkedList() {
		Node current = head;
		while(current.next != null) {
			System.out.print(current.data+ " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		// 1 -> null
		linkedList.pushFront(1);
		
		// 1 -> 2 -> null
		linkedList.append(2);
		
		// 1 -> 1 -> 2 -> null
		linkedList.pushFront(1);
		
		// 1 -> 1 -> 2 -> 4 -> null
		linkedList.append(4);
		
		// 0 -> 1 -> 1 -> 2 -> 4 -> null
		linkedList.pushFront(0);
		
		// 0 -> 1 -> 5 -> 1 -> 2 -> 4 -> null
		linkedList.insertAfter(linkedList.head.next, 5);
		linkedList.printLinkedList();
		
		linkedList.deleteNode(5);
		
		linkedList.printLinkedList();
		
		linkedList.deleteAtPosition(2);
		
		linkedList.printLinkedList();
		
		Node temp = linkedList.searchNode(1);
		System.out.println(temp.data);
		
		LinkedList ls = new LinkedList();
		ls.pushFront(1);
		ls.pushFront(2);
		ls.pushFront(3);
		System.out.println("Stack LIFO:");
		ls.printLinkedList();
		
		ls.remove();
		System.out.println("After removing from Stack:");
		ls.printLinkedList();
	}
}
