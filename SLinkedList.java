package eg.edu.alexu.csd.datastructure.stack.cs;

public class SLinkedList {
	 public Node head ;
	 public Node tail ;
public	SLinkedList () {			}

public void addatlast( Object element) { 
    Node newNode = new Node(element);
    if (head == null && tail == null) {
        head = newNode;
        tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
}

public Object get() {

    if (head == null) {
        throw new IndexOutOfBoundsException();
    }
    Node temp;
    temp = head;
    int z = size() ;
    for (int i = 0; i < z-1 ; i++) {
        temp = temp.next;
    }

    Object output = temp.element ; 
    
    return output;

}
public boolean isEmpty() {

    return (head == null);

}

public void remove() { 
Node temp ; temp = head ;int z = size();
		if(1 == z) {
			head = null ;
			tail = null ;
			return ;
		}
		else {
			
        for (int i = 1; i < z-1 ; i++) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
		}
    }

public int size() { 

    int count = 1;
    Node temp;
    temp = head;

    if (isEmpty()) {
        return 0;
    } else {
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

}
