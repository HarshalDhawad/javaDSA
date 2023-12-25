package queue;

public class DynamicQ extends CirclularQ{

    public DynamicQ(){
        super();
    }
    public DynamicQ(int  size){
        super(size);
    }

    @Override
    public boolean insert(int item){
        if(this.isfull()){

            int[] temp = new int[data.length*2];

            for(int i=0;i<data.length;i++){
                temp[i]= data[(start+i)%data.length];
            }
            start = 0;
            end=data.length;
            data=temp;
        }
        return super.insert(item);
    }
}
