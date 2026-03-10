import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

class SetOfStacks {

    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int capacity;

    SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    Stack<Integer> getLastStack(){
        if(stacks.size() == 0)
            return null;

        return stacks.get(stacks.size() - 1);
    }

    void push(int value){

        Stack<Integer> last = getLastStack();

        if(last != null && last.size() < capacity){
            last.push(value);
        } 
        else {
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            stacks.add(stack);
        }
    }

    int pop(){

        Stack<Integer> last = getLastStack();

        if(last == null)
            throw new EmptyStackException();

        int value = last.pop();

        if(last.isEmpty())
            stacks.remove(stacks.size() - 1);

        return value;
    }
}

public class SetOfPlatesProblem {

    public static void main(String[] args) {

        SetOfStacks set = new SetOfStacks(3);

        set.push(10);
        set.push(20);
        set.push(30);
        set.push(40);
        set.push(50);
        set.push(60);

        System.out.println("Popped: " + set.pop());
        System.out.println("Popped: " + set.pop());
        System.out.println("Popped: " + set.pop());
    }
}
