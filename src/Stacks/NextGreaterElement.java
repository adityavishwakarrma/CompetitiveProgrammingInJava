package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        // 4  25  2  2  5  7  8
        // 5 can be next greater for many previous elements
        // => stacks can store the previous elements

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,4,5,6));
        ArrayList<Integer> nge = new ArrayList<>(arr.size());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nge.size(); i++){
            while (!stack.empty() && arr.get(stack.peek()) < arr.get(i)){
                nge.set(stack.peek(), i);
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.empty()){
            nge.set(stack.peek(), -1);
            stack.pop();
        }
    }
}
