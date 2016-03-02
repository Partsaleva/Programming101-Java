package list;
 
public class Test {

	boolean test1(){
		DoublyLinkedList l=new DoublyLinkedList();
		try {
			l.popBack();
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println("test1: popBack() from empty list throw!");
			return true;
		}
		return false;
	}

	boolean test2(){
		DoublyLinkedList l=new DoublyLinkedList();
		try {
			l.popFront();
		}
		catch (Exception err ) {
			System.out.println(err.getMessage());
			System.out.println("test2: popFront() from empty list throw!");
			return true;
		}
		return false;
	}

	void test3()
	{
		System.out.println("test 3: pushFront(*) popBack()");
		DoublyLinkedList list1=new DoublyLinkedList();
		try
		{
			list1.pushFront(42);
			list1.popBack();
			System.out.print("print: ");list1.print();
		}
		catch (Exception err )
		{
			System.out.println(err.getMessage());
		}

	}

	void test4()
	{
		System.out.println("test 4: pushFront(*) popFront()");
		DoublyLinkedList list1=new DoublyLinkedList();
		try
		{
			list1.pushFront(42);
			list1.popFront();
			System.out.print("print: ");  list1.print();
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}

	}

	void test5(){
		System.out.println("test 5: pushBack(*) popBack()");
		DoublyLinkedList list2=new DoublyLinkedList();
		try{
			list2.pushBack(43);
			list2.popBack();
			System.out.print("print: ");  list2.print(); 
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

	void test6(){
		System.out.println("test 6: pushBack(*) popFront()");
		DoublyLinkedList list2=new DoublyLinkedList();
		try{
			list2.pushBack(43);
			list2.popFront();
			System.out.print("print: ");  list2.print(); 
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

	void test7(){
		System.out.println("test 7: push order");
		DoublyLinkedList list=new DoublyLinkedList();
		try{
			list.pushBack(1);
			list.pushBack(2);
			list.pushBack(3);
			list.pushFront(4);
			list.pushFront(5);
			list.pushFront(7);
			System.out.print("print: ");  list.print(); 
			System.out.println(list.find(1));
			System.out.println(list.find(2));
			System.out.println(list.find(3));
			System.out.println(list.find(4));
			System.out.println(list.find(5));
			System.out.println(list.find(7));
			System.out.println(list.find(6));
			System.out.println(list.find(8));
			System.out.println(list.find(9));
			System.out.println(list.find(0));
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

	void test8(){
		System.out.println("test 8: push front and back");
		DoublyLinkedList list=new DoublyLinkedList();
		try{
			list.pushBack(1);
			list.pushBack(2);
			list.pushBack(3);
			list.pushFront(4);
			list.pushFront(5);
			list.pushFront(7);
			System.out.println("print: ");list.print();
			list.popFront();
			System.out.println("print: ");  list.print();
			list.popBack();
			System.out.println("print: ");  list.print(); 
			list.pushFront(3);
			System.out.println("print: ");  list.print(); 
			list.pushBack(9);
			System.out.println("print: ");  list.print(); 
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

	void test9(){
		System.out.println("test 9: insert");
		DoublyLinkedList list=new DoublyLinkedList();
		try{
			list.insert(0, 9);
			System.out.println("print: ");  list.print(); 
			list.pushBack(1);
			list.pushBack(2);
			list.pushBack(3);
			list.pushFront(4);
			list.pushFront(5);
			list.pushFront(7);
			System.out.println("print: ");list.print();
			list.insert(0, 6);
			System.out.println("print: ");list.print();
			System.out.println("size: " );list.listSize();
			list.insert(list.listSize(), 5);
			System.out.println("print: ");  list.print(); 
			System.out.println("size" +list.listSize());
			list.insert(3, 1);
			System.out.println("print: ");  list.print(); 
		}
		catch (Exception err )
		{
			System.out.println(err.getMessage());
		}
	}

	void test10(){
		System.out.println("test 10: remove");
		DoublyLinkedList list=new DoublyLinkedList();
		try{
			list.pushBack(1);
			list.pushFront(4);
			list.pushBack(2);
			list.pushFront(5);
			list.pushBack(3);
			list.pushFront(7);
			System.out.println("print: ");  list.print(); 
			list.remove(4);
			System.out.println("print: ");  list.print(); 
			list.remove(7);
			System.out.println("print: ");  list.print(); 
			list.remove(3);
			System.out.println("print: ");  list.print(); 
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
}

