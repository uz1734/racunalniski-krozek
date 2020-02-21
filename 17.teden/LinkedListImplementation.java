import java.io.*; 

// Java program to implement 
// a Singly Linked List
 
class LinkedList { 
  
    Node head;

	static class Node { 

		int data; 
		Node next; 

		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
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
	
	public static LinkedList insertAtTheBeginning(LinkedList list, int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = list.head;
		
		list.head = new_node;
		
		return list;
	}
	
	public static LinkedList insertAtGivenPosition(LinkedList list, int data, int position)
	{
        Node new_node = new Node(data); 
        new_node.next = null; 
	
        if (list.head == null) { 
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
	
	public static LinkedList deleteNode(LinkedList list, int key) 
    {  
        Node temp = list.head; 
		Node prev = null; 
  
        if (temp != null && temp.data == key) 
        { 
            list.head = temp.next; 
            return list;
        } 
   
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
   
        if (temp == null) 
		{
			return list;
		} 
  
        prev.next = temp.next;
		return list;
    } 
	
  
    // Method to print the LinkedList. 
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
   
            currNode = currNode.next; 
        } 
    }  
} 

public class LinkedListImplementation {
	
	public static void main(String[] args) {
		System.out.println("It works");
		

        LinkedList list = new LinkedList(); 
  
        list = LinkedList.insert(list, 1); 
        list = LinkedList.insert(list, 2); 
        list = LinkedList.insert(list, 3); 
        list = LinkedList.insert(list, 4); 
        list = LinkedList.insert(list, 5); 
        list = LinkedList.insert(list, 6); 
        list = LinkedList.insert(list, 7); 
        list = LinkedList.insert(list, 8);
		list = LinkedList.insertAtTheBeginning(list, 10);
		list = LinkedList.insertAtGivenPosition(list, 55, 3);
		
		LinkedList.printList(list);
		
		list = LinkedList.deleteNode(list, 3);
		System.out.println();
		System.out.println();
		LinkedList.printList(list);
		
	}
}
