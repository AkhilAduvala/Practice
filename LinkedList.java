public class LinkedList {

    //code to create a node class
    private static class Node{

        private int data;
        private Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    private Node head;

    LinkedList(){
        head = null;
    }

    //adds node at the start of the linkedlist
    public void addFirst(int data){
        if(head == null){
            Node node = new Node(data);
            head = node;
        }else{
            Node node = new Node(data, head);
            head = node;
        }
    }

    //adds node at the end of the linkedlist
    public void addLast(int data){
        if(head == null){
            Node node = new Node(data);
            head = node;
        }else{
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            Node node = new Node(data);
            currentNode.next = node;
        }
    }

    //adds node at the pos of the linkedlist
    public void addMiddle(int data, int pos){
        if (pos == 0) {
            addFirst(data);
            return;
        }

        if (head == null) {
            System.out.println("You can't add a node at position " + pos + " as the linked list is empty.");
            return;
        }

        Node currentNode = head;
        int currentPOS = 0;

        while (currentPOS < pos - 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            currentPOS++;
        }

        if (currentPOS < pos - 1) {
            System.out.println("You are trying to insert a node beyond the size of the linked list.");
        } else {
            Node node = new Node(data, currentNode.next);
            currentNode.next = node;
        }
    }


    //remove the first node of the linkedlist
    public void removeFirst(){
        if(head == null){
            System.out.println("Linkedlist is already empty");
        } else if (head.next == null) {
            head = null;
        }else{
            head = head.next;
        }
    }

    //remove the last node of the linkedlist
    public void removeLast(){
        if(head == null){
            System.out.println("Linkedlist is already empty");
        } else if (head.next == null) {
            head = null;
        }else{
            Node currentNode = head;
            while(currentNode.next.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }
    }

    // Remove node at the specified position in the linkedlist
    public void removeMiddle(int pos) {
        if (head == null) {
            System.out.println("Linked list is already empty");
            return;
        }

        // If position is 0, remove the first node
        if (pos == 0) {
            removeFirst();
            return;
        }

        Node currentNode = head;
        int currentPos = 0;

        // Traverse to the node just before the one to be deleted
        while (currentPos < pos - 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            currentPos++;
        }

        // If `currentNode.next` is null, it means position is out of bounds
        if (currentNode.next == null) {
            System.out.println("Position out of bounds. No node to remove.");
            return;
        }

        // Remove the node by skipping it
        currentNode.next = currentNode.next.next;
    }


    //prints the entire linkedlist
    public void display(){
        if(head == null){
            System.out.println("Linkedlist is empty");
        }else{
            Node currentNode = head;
            while(currentNode != null){  // Traverse until null
                System.out.print(currentNode.data + " -> "); // Print node data
                currentNode = currentNode.next;
            }
            System.out.println("null");
        }
    }

    //search for a value in linkedlist
    public boolean search(int data){
        if(head == null){
            System.out.println("linkedlist is empty");
            return false;
        }else{
            Node currentNode = head;
            while(currentNode != null){
                if(currentNode.data == data){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    //to get the size of the linkedlist
    public int size(){
        int size = 0;
        Node currenNode = head;
        while (currenNode != null){
            currenNode = currenNode.next;
            size++;
        }
        return size;
    }
}
