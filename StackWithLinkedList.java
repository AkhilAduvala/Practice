import java.util.LinkedList;
import java.util.List;

public class StackWithLinkedList {

    private Node top;

    public StackWithLinkedList(){
        top = null;
    }

    public void push(int x){
        Node newNode = new Node(x, top);
        top = newNode;
    }

    public int pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.getData();
        top = top.getNext();
        return data;
    }

    public int peek(){
        if (top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.getData();
    }

    public boolean search(int x){
        if (top == null){
            return false;
        }
        Node current = top;
        while(current != null){
            if(current.getData() == x){
                return true;
            }else{
                current = current.getNext();
            }
        }
        return false;
    }

    public int size(){
        Node current = top;
        int count = 0;
        while(current != null){
            current = current.getNext();
            count++;
        }
        return count;
    }

    public void display(){
        if(top == null){
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
