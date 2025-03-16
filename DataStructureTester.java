public class DataStructureTester {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addFirst(5);
        linkedList.addMiddle(15, 2);

        linkedList.display();

        System.out.println(linkedList.search(11));
        System.out.println(linkedList.search(10));

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


    }
}
