package recursion;

public class sumArr {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        System.out.println(sumarr(arr , 0));

    }
    public static int sumarr(int[] arr ,int size){
        if(size==arr.length){
            return 0;
        }

        return arr[size] + sumarr(arr,size+1);


    }
}
