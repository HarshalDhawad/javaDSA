package recursion;

public class maxNmin {
    public static void main(String[] args) {
        int[] a = {1,4,3,-5,-4,8,6};
        System.out.println(Min(a , 0));
        System.out.println(Max(a , 0));
    }
    public static int Min(int[] a ,int s ){

        if(s==a.length-1){
            return a[s];
        }
        return Math.min(a[s],Min(a,s+1));
    }

    public static int Max(int[] a ,int s ){

        if(s==a.length-1){
            return a[s];
        }
        return Math.max(a[s],Max(a,s+1));
    }
}
