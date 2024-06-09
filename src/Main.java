

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
//        sort(arr, 0, arr.length - 1);
        setZeroes(arr);
//        System.out.println(arr);
        System.out.println(Arrays.deepToString(arr));
//        Arrays.sort(arr);
    }

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }

        public static void setZeroes(int[][] matrix) {
            boolean fr = false,fc = false;
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0) {
                        if(i == 0) fr = true;
                        if(j == 0) fc = true;
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for(int i = 1; i < matrix.length; i++) {
                for(int j = 1; j < matrix[0].length; j++) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }}
            }
            if(fr) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[0][j] = 0;
                }
            }
            if(fc) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
}