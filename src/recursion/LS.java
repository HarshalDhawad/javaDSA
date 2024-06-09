package recursion;

public class LS {
    public static void main(String[] args) {
        int[] arr ={2,3,4,1,12};
        System.out.println(linearsearch(arr,0,1));
    }
    public static boolean linearsearch(int[] arr ,int i,int tar){
        if(i==arr.length){
            return false;
        }
        if(arr[i]!=tar){
            return linearsearch(arr , i+1,tar);
        }
        return true;
    }
}
