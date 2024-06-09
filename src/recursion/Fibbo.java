package recursion;

public class Fibbo {
    public static void main(String[] args) {
        System.out.println(fibb(6));
    }

    public static int fibb(int n){
        if(n<2){
            return n;
        }
        int ans = fibb(n-1)+fibb(n-2);

        return ans;
    }
}
