import java.util.ArrayList;
import java.util.List;

public class StackWithArrayList {

    private int top;
    private List<Integer> stackList;

    StackWithArrayList(){
        stackList = new ArrayList<>();
        top = -1;
    }

    public void push(int x){
        top++;
        stackList.add(x);
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack is already empty");
            return -1;
        }else{
            return stackList.remove(top--);
        }
    }

    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return stackList.get(top);
        }
    }

    public int search(int x){
        int index = stackList.lastIndexOf(x);
        return (index == -1) ? -1 : (top - index + 1);
    }

    public int size(){
        return top + 1;
    }

    public void display(){
        for (int i = top; i > -1; i--){
            System.out.println(stackList.get(i));
        }
    }
}
