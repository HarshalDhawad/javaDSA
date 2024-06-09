package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

public class powerset {
    public static void main(String[] args) {

        String s = "abc";

        ArrayList<String> outer = new ArrayList<>();
        String inner = "";
        int index = 0;
        powerlex(s , outer , inner ,index);
        System.out.println(outer);

    }
    public static void powerlex(String s , ArrayList<String> outer ,String inner, int i){
       if(i>s.length()-1){
           outer.add(inner);
           return;
       }
       //exclude
        powerlex(s,outer,inner,i+1);

       //include
        char ch = s.charAt(i);
        powerlex(s,outer,inner+ch,i+1);
    }

}
