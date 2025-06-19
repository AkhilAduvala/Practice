public class DataStructureTester {

    public static void main(String[] args){

        System.out.println("Lets see singly linkedlist");
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addFirst(5);
        linkedList.addMiddle(15, 2);

        linkedList.display();

        System.out.println(linkedList.search(11));
        System.out.println(linkedList.search(10));

        System.out.println("lets see doubly linkedlist");

        DoublyLinkedList list = new DoublyLinkedList();

        // Adding elements
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addMiddle(1, 15);
        list.addMiddle(0, 5);

        // Display list
        System.out.print("Forward: ");
        list.displayForward();

        System.out.print("Backward: ");
        list.displayBackward();

        // Removing elements
        list.removeFirst();
        list.removeLast();
        list.removeMiddle(1);

        // Display list after deletions
        System.out.print("After Deletion Forward: ");
        list.displayForward();

        System.out.print("After Deletion Backward: ");
        list.displayBackward();

        // Searching elements
        System.out.println("Search 15: " + list.search(15));
        System.out.println("Search 20: " + list.search(20));

        // Size of list
        System.out.println("Size: " + list.size());

        System.out.println("Now lets see arrayList impl of stack");

        StackWithArrayList stack = new StackWithArrayList();
        System.out.println("Element popped : " + stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.display();

        System.out.println("Top element of the stack : " + stack.peek());

        System.out.println("Element popped : " + stack.pop());

        System.out.println("after poping the top element, stack is : " );
        stack.display();

        System.out.println("Now lets see linkedlist impl of stack");

        StackWithLinkedList stackWithLinkedList = new StackWithLinkedList();

        System.out.println("Element popped : " + stackWithLinkedList.pop());
        stackWithLinkedList.push(1);
        stackWithLinkedList.push(2);
        stackWithLinkedList.push(3);
        stackWithLinkedList.push(4);

        stackWithLinkedList.display();

        System.out.println("Top element of the stack : " + stackWithLinkedList.peek());

        System.out.println("Element popped : " + stackWithLinkedList.pop());

        System.out.println("after poping the top element, stack is : " );
        stackWithLinkedList.display();

    }
}
