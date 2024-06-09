package recursion;

public class isuppercase {
    public static void main(String[] args) {
        String s = "geeKs";
        System.out.println(uppercase(s,0));

    }
    public static char uppercase(String s , int i){
        if(i==s.length()){
            return 0;
        }

        if(Character.isUpperCase(s.charAt(i))){
            return s.charAt(i);
        }
        return uppercase(s,i+1);
    }
}
