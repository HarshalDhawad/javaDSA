package queue;

public class CustomQ {

    protected int[] data ;
    private static final int DEFAULT_SIZE=10;
    int end=0;
    public CustomQ(){
        this(DEFAULT_SIZE);
    }
    public CustomQ(int size){
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(isfull()){
            return false;
        }
        data[end++]=item;
        return true;
    }

    public int delete() throws Exception{
        if(isempty()){
            throw new Exception("Queue is empty");
        }
        int removedValue=data[0];
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removedValue;
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public boolean isempty() {
        return end==0;
    }

    public boolean isfull() {
        return end==data.length;
    }

}
