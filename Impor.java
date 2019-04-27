package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.Scanner;

import javax.swing.InputMap;

 class Impor implements IStack {
	 SLinkedList essam = new SLinkedList();
	 
	 public Object peek() {
		 if (isEmpty()) {  System.out.print("Stack is empty ");
		 return null ;}
		 Object ahmed = new Object();
		 ahmed = essam.get();
		 System.out.println("the top of stack "+ahmed);
		 return ahmed ; 
	 }
	 
	 public Object pop() {
		 if (isEmpty()) { System.out.print("Stack is empty ");
		 return null ;}
		 Object ahmed = new Object();
		 ahmed = essam.get(); 
		 essam.remove();
		 System.out.println("pop  "+ahmed+" from stack ");
		 return ahmed ; 
	 }
	 
	public void push(Object element) {
		essam.addatlast(element);
	}
	
	public boolean isEmpty () {
		if(size() == 0) return true ; 
		else {return false ;}
	}
	
	public int size() {
		int i = essam.size();
		if(i == 0) { System.out.println("Stack is empty ");
		return 0 ;}
		else {
			return i ;
		}
	}
	public static void main (String[]args) throws Exception {
		Impor STA = new Impor();
		while(true) {
		System.out.println("Choose an action \r\n");
		System.out.println("1-push \r\n");
		System.out.println("2-Pop \r\n");
		System.out.println("3-Peek \r\n");
		System.out.println("4-Get Size\r\n");
		System.out.println("5-Check if empty \r\n");
		Scanner sasa = new Scanner(System.in);
		int h = sasa.nextInt() ; 
		
		if(h == 1) {
			System.out.println("Please enter the element\r\n");
			Object f = sasa.nextDouble();
			STA.push(f);
		}
		else if(h == 2) {
			System.out.println(STA.pop()+"\n");
		}
		else if(h == 3) {
			System.out.println(STA.peek()+"\n");
		}
		else if( h == 4) {
			System.out.println(STA.size()+"\n");
		}
		else if(h == 5) {
			System.out.println(STA.isEmpty()+"\n");
		}
		else {
			System.out.print("InVaildInput \n");
		}
		}
	}
}
