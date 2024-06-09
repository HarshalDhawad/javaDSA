package BinarySearch;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}

        };
//        System.out.println(Arrays.toString(search(arr, 9)));
        System.out.println(search(arr,3));
    }

//    static int[] binarySearch(int[][] arr ,int row ,int cstart,int cend,int target){
//        while(cstart<=cend){
//            int mid = cstart + (cend-cstart) /2;
//
//            if(arr[row][mid]==target){
//                return new int[]{row,mid};
//            }
//            else if(arr[row][mid]<target){
//                cstart = mid+1;
//            }
//            else{
//                cend=mid-1;
//            }
//        }
//        return new int[]{-1,-1};
//    }
//
//  static int[] search(int[][] arr , int target){
//        int rows = arr.length;
//        int cols = arr[0].length;
//
//        if(cols==0){
//            return new int[] { -1,-1 };
//        }
//        if(rows==1){
//            return binarySearch(arr,0,0,cols-1,target);
//        }
//        int rstart=0;
//        int rend=rows-1;
//        int cmid = cols/2;
//
//        while(rstart<rend-1){
//            int mid = rstart + (rend-rstart)/2;
//            if(arr[mid][cmid]==target){
//                return new int[]{mid,cmid};
//            }
//            if(arr[mid][cmid]<target){
//                rstart=mid;
//            }
//            else{
//                rend=mid;
//            }
//        }
//
//        if(arr[rstart][cmid]==target){
//            return new int[]{rstart,cmid};
//        }
//        if(arr[rstart+1][cmid]==target){
//            return new int[]{rstart+1,cmid};
//        }
//
//        if(target<arr[rstart][cmid-1]){
//            return binarySearch(arr,rstart,0,cmid-1,target);
//        }
//
//        if(target>arr[rstart][cmid-1] && target<arr[rstart][cols-1]){
//            return binarySearch(arr,rstart,cmid+1,cols-1,target);
//        }
//
//        if(target<arr[rstart+1][cmid-1]){
//            return binarySearch(arr,rstart+1,0,cmid-1,target);
//        }
//
//        else{
//            return binarySearch(arr,rstart+1,cmid+1,cols-1,target);
//        }
//
//
//


      public static boolean binarySearch(int[][] arr ,int row ,int cstart,int cend,int target){
          while(cstart<=cend){
              int mid = cstart + (cend-cstart) /2;

              if(arr[row][mid]==target){
                  return true;
              }
              else if(arr[row][mid]<target){
                  cstart = mid+1;
              }
              else{
                  cend=mid-1;
              }
          }
          return false;
      }

      public static boolean search(int[][] arr , int target){
          int rows = arr.length;
          int cols = arr[0].length;

          if(cols==0){
              return false;
          }
          if(rows==1){
              return binarySearch(arr,0,0,cols-1,target);
          }
          int rstart=0;
          int rend=rows-1;
          int cmid = cols/2;

          while(rstart<(rend-1)){
              int mid = rstart + (rend-rstart)/2;
              if(arr[mid][cmid]==target){
                  return true;
              }
              if(arr[mid][cmid]<target){
                  rstart=mid;
              }
              else{
                  rend=mid;
              }
          }

          if(arr[rstart][cmid]==target){
              return true;
          }
          if(arr[rstart+1][cmid]==target){
              return true;
          }

          if(target<=arr[rstart][cmid]){
              return binarySearch(arr,rstart,0,cmid-1,target);
          }

          if(target>=arr[rstart][cmid] && target<=arr[rstart][cols-1]){
              return binarySearch(arr,rstart,cmid+1,cols-1,target);
          }

          if(target<=arr[rstart+1][cmid]){
              return binarySearch(arr,rstart+1,0,cmid-1,target);
          }

          else{
              return binarySearch(arr,rstart+1,cmid+1,cols-1,target);
          }



      }



  }

