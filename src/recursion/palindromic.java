package recursion;
import java.util.ArrayList;

public class palindromic {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        String s = "geeks";

        int ind = 0;

        // Store the partition at current iteration
        ArrayList<String> curr = new ArrayList<>();

        // calling funtion to get partition
        partition(res, s, ind, curr);

        for(ArrayList<String> iter : res) {
            System.out.println(iter);
        }
    }

    private static void partition(ArrayList<ArrayList<String>> res, String s, int ind, ArrayList<String> curr) {
        if(ind>=s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        String temp ="";
        for(int i=ind;i<s.length();i++){
            temp+=s.charAt(i);

            if(ispalindrom(temp)){
                 curr.add(temp);
                 partition(res , s , ind+1 ,curr);

                 curr.remove(curr.size()-1);
            }
        }
    }

    private static boolean ispalindrom(String temp) {
        int n = temp.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(temp.charAt(i)!=temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
