package stack;

import java.util.Stack;

public class removeValidParentheses {
    public static void main(String[] args) {
        String s= "lee(t(c)o)de)";
        System.out.println(s.length());
        System.out.println(minRemoveToMakeValid(s));

    }

        public static String minRemoveToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else if(ch=='(') {
                    stack.push(ch);
                }
            }
            String str = "";
            for(char ch : s.toCharArray()){
                if(!stack.isEmpty()) {
                    if (ch == '(' && stack.peek()=='(' ) {
                        stack.pop();
                    }
                    else if(ch == ')' && stack.peek()==')' ){
                        stack.pop();
                    }
                    else{
                        str+=ch;
                    }
                }
                else{
                    str+=ch;
                }
            }

            return str;

        }
    }

