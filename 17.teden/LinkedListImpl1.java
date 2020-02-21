class Node {
	public int data;
	public Node next;
	
	Node(int st) {
		this.data = st;
	}	
}


class LinkedList {
	
	Node head;
	
	public static LinkedList instertAtBeginngin(LinkedList list, 
		int data) {
		
		Node newNode = new Node(data);
		
		if (list.head == null) {
			list.head = newNode;
			return list;
		}
		
		newNode.next = list.head;
		list.head = newNode;
		
		return list;
	}
		
	public static LinkedList insert(LinkedList list, int data) 
    { 
  
        Node new_node = new Node(data); 
        new_node.next = null; 
  
 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
   
            last.next = new_node; 
        } 
   
        return list; 
    }
	
	public static LinkedList inseertAtIndex(LinkedList list, int data, int position) {
		Node new_node = new Node(data); 
        new_node.next = null; 
	
        if (list.head == null) { 
            list.head = new_node; 
        }
		else if (position == 0) {
			new_node.next = list.head;
			list.head = new_node;
		}
        else { 

            Node last = list.head; 
			int tmpPosition = 0;
            while (last.next != null && tmpPosition != position - 1) { 
                last = last.next; 
				tmpPosition++;				
            } 
			
			if (last.next == null) {
				last.next = new_node; 
			}
			else {
				new_node.next = last.next;
				last.next = new_node;
			}
			
        } 
 
        return list;
	}
	
	public static LinkedList deleteNode(LinkedList list, int dataForDeletion){
		
		Node tmp = list.head;
		if (tmp != null && tmp.data == dataForDeletion) {
			list.head = tmp.next;
			return list;
		}
		
		Node prev = null;
		while (tmp.next != null && tmp.data != dataForDeletion) {
			prev = tmp;
			tmp = tmp.next;
		}
		
		if (tmp == null) 
		{
			return list;
		}
		
		prev.next = tmp.next;
		
		return list;
		
	}
	
	
	public static void printList(LinkedList list) {
		Node tmp = list.head;
		
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		
	}
	
	
}


class LinkedListImpl1 {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list = LinkedList.instertAtBeginngin(list, 2);
		list = LinkedList.instertAtBeginngin(list, 3);
		list = LinkedList.instertAtBeginngin(list, 4);
		list = LinkedList.insert(list, 6);
	
		LinkedList.printList(list);
		System.out.println();
		
		list = LinkedList.inseertAtIndex(list, 55, 2);
		list = LinkedList.inseertAtIndex(list, 11, 0);
		LinkedList.printList(list);
		System.out.println();
		
		list = LinkedList.deleteNode(list, 6);
		LinkedList.printList(list);
	}
	
	
}