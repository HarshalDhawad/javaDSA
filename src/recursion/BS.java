package recursion;

import java.util.Arrays;

public class BS {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(search(arr,6,0,arr.length-1));

    }


    public static int search(int[] arr , int tar ,int s ,int e){
        if(s>e){
            return -1;
        }

        int m = s+(e-s)/2;

        if(arr[m]==tar){
            return m;
        }
        if(arr[m]>tar){
             return search(arr , tar , s , m-1);
        }
        return search(arr , tar , m+1 , e);
    }


    public static int helper(int[] nums , int tar ,int s ,int e){
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;

        if(nums[mid]==tar){
            return mid;
        }
        if(nums[mid]>tar){
            return helper(nums , tar , s ,mid-1);
        }
        return helper(nums , tar , mid ,e);

    }
}
