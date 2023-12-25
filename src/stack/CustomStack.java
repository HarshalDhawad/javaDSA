package stack;

public class CustomStack {

    protected int[] data ;
    private static final int DEFAULT_SIZE = 10;

    int ptr=-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isfull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop() throws StackException{
        if(isempty()){
            throw new StackException("cannot pop from an empty stack");
        }
        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isempty()){
            throw new StackException("cannot peek from an empty stack");
        }
        return data[ptr];
    }

    private boolean isempty() throws StackException {
        return ptr==-1;
    }

    public boolean isfull() {
        return ptr == data.length-1;
    }

}
