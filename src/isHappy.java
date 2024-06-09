public class isHappy {
    public static void main(String[] args) {

        System.out.println(ishappy(19));
    }
    public static boolean ishappy(int n){
        if(n<10 && n>1 && n==0){
            return false;
        }
        int sum=0;
        while(n!=0){
            int rem = n%10;
            sum += rem*rem;
            n/=10;
        }
        if(sum==1){
            return true;
        }

        ishappy(sum);
        return false;
    }

}
