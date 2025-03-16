public class DoublyLinkedList {

    // Node class representing a single node in the doubly linked list
    private static class Node {
        private int data;
        private Node prev;
        private Node next;

        // Constructor to initialize a node with data, previous, and next references
        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        // Constructor to initialize a node with data only (prev and next are null)
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head; // Points to the first node
    private Node tail; // Points to the last node

    // Constructor initializes an empty doubly linked list
    DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a node at the beginning of the doubly linked list
    public void addFirst(int data) {
        if (head == null) {
            Node node = new Node(data);
            head = node;
            tail = node; // If the list was empty, tail should also point to the new node
        } else {
            Node node = new Node(data, null, head);
            head.prev = node;
            head = node;
        }
    }

    // Add a node at the end of the doubly linked list
    public void addLast(int data) {
        if (tail == null) {
            Node node = new Node(data);
            head = node;
            tail = node; // If the list was empty, head should also point to the new node
        } else {
            Node node = new Node(data, tail, null);
            tail.next = node;
            tail = node;
        }
    }

    // Add a node at the specified position in the doubly linked list
    public void addMiddle(int pos, int data) {
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

        // Traverse to the position before where we want to insert
        while (currentPOS < pos - 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            currentPOS++;
        }

        if (currentPOS < pos - 1) {
            System.out.println("You are trying to insert a node beyond the size of the linked list.");
        } else {
            Node node = new Node(data, currentNode, currentNode.next);
            if (currentNode.next != null) {
                currentNode.next.prev = node;
            } else {
                tail = node; // If inserted at the end, update tail
            }
            currentNode.next = node;
        }
    }

    // Remove the first node from the doubly linked list
    public void removeFirst() {
        if (head == null) {
            System.out.println("Linked list is already empty");
            return;
        }
        head = head.next; // Move head to the next node
        if (head == null) { // If the list is empty now, update tail
            tail = null;
        } else {
            head.prev = null;
        }
    }

    // Remove the last node from the doubly linked list
    public void removeLast() {
        if (tail == null) {
            System.out.println("Linked list is already empty");
            return;
        }
        tail = tail.prev; // Move tail to the previous node
        if (tail == null) { // If the list is empty now, update head
            head = null;
        } else {
            tail.next = null;
        }
    }

    // Remove a node from a specified position in the doubly linked list
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

        // If `currentNode.next` is null, the position is out of bounds
        if (currentNode.next == null) {
            System.out.println("Position out of bounds. No node to remove.");
            return;
        }

        // If we are removing the last node
        if (currentNode.next == tail) {
            removeLast();
            return;
        }

        // Remove the node by skipping it
        Node adjust = currentNode.next.next;
        currentNode.next = adjust;

        // Update prev pointer of `adjust`
        if (adjust != null) {
            adjust.prev = currentNode;
        } else {
            tail = currentNode; // If adjust is null, we are at the new last node
        }
    }

    // Print the linked list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) { // Traverse until null
            System.out.print(currentNode.data + " -> "); // Print node data
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    // Print the linked list in backward direction
    public void displayBackward() {
        if (tail == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currentNode = tail;
        while (currentNode != null) { // Traverse until null
            System.out.print(currentNode.data + " <- "); // Print node data
            currentNode = currentNode.prev;
        }
        System.out.println("null");
    }

    // Search for a value in the linked list
    public boolean search(int data) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return false;
        }
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == data) {
                return true; // Found the element
            }
            currentNode = currentNode.next;
        }
        return false; // Element not found
    }

    // Get the size of the linked list
    public int size() {
        int size = 0;
        Node currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }
}
