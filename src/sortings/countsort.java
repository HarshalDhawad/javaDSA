package sortings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countsort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,3,2,5,2,8};
        countHash(arr);
        System.out.println(Arrays.toString(arr));



    }
    public static void countHash(int[] arr){
        if(arr.length<=1){
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        Map<Integer,Integer> countmap = new HashMap<>();

        for (int num : arr){
            countmap.put(num,countmap.getOrDefault(num,0)+1);
        }

        int index =0;
        for (int i = min; i < max ; i++) {
            int count = countmap.getOrDefault(i,0);
            for (int j = 0; j < count; j++) {
                arr[index]=i;
                index++;
            }
        }
    }
    public static void count(int[] arr){
        if(arr.length<=1){
            return;
        }
        int max = arr[0];
        for(int num : arr){
            if(num>max){
                max=num;
            }
        }

        int[] countarray = new int[max+1];

        for(int num : arr){
            countarray[num]++;
        }

        int index = 0;
        for (int i=0;i<arr.length;i++){
            while(countarray[i]>0){
                arr[index]=i;
                index++;
                countarray[i]--;
            }
        }
    }
}
