package recursion;

import java.util.Arrays;

public class SumTraingle {
    public static void main(String[] args) {
        int[] a  = {1,2,3,4,5};
        printTriangle(a);

    }
    public static void printTriangle(int[] a){
        if(a.length<1){
            return;
        }
        int[] temp= new int[a.length-1];
        for(int i = 0;i<temp.length;i++){
            temp[i]=a[i]+a[i+1];
        }
        printTriangle(temp);

        System.out.println(Arrays.toString(a));
    }
}
