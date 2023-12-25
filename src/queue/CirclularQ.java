package queue;

public class CirclularQ {
    protected int[] data ;
    private static final int DEFAULT_SIZE=10;
    int end=0;
    int start=0;
    int size=0;

    public CirclularQ(){
        this(DEFAULT_SIZE);
    }
    public CirclularQ(int size){
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(isfull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end++]=item;
        end%=data.length;
        size++;
        return true;
    }

    public int delete() throws Exception{
        if(isempty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[start++];
        start = start % data.length;
        size--;
        return removed;
    }

    public void display() throws Exception{
        if(isempty()){
            throw new Exception("Queue is empty");
        }
        int i=start;
        do{
            System.out.print(data[i]+"->");
            i++;
            i%=data.length;
        }while(i!=end);
        System.out.println("END");
    }

    public boolean isempty() {
        return size==0;
    }

    public boolean isfull() {
        return size==data.length;
    }
}
