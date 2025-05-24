package Stacks;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        HashMap<Character, Integer> symbols = new HashMap<>();
        symbols.put('[',-1);
        symbols.put(']',1);
        symbols.put('(',-2);
        symbols.put(')',2);
        symbols.put('{',-2);
        symbols.put('}',3);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        for(char bracket : s.toCharArray()){
            if(symbols.get(bracket) < 0){
                //opening bracket
                stack.push(bracket);
            }
            else {
                //closing bracket
                char closing = bracket;

                //take out element from stack
                if(stack.empty()) {
                    System.out.println("No");
                    return;
                }

                char opening = stack.peek();
                stack.pop();

                if(symbols.get(closing) + symbols.get(opening) != 0){
                    System.out.println("No");
                    return;
                }
            }
        }

        if(stack.empty()) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
