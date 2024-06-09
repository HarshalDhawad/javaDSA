package sortings;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] arr = {23,12,3,56,22};
        bubble(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble(int[] arr,int k){
       if(k==0 || k==1){
            return ;
        }
        for(int i=0;i<k-1;i++){
            if(arr[i]>arr[i+1]){
                swap(arr , i , i+1);
            }
        }

        bubble(arr , k-1);

    }
    public static void swap(int[] arr ,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
