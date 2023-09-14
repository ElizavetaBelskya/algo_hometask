package src.main.java;

import java.util.Scanner;
import java.util.Stack;

public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        Stack<Integer> stack = new Stack<>();
        String[] colors = sc.nextLine().split(" ");
        for (int i = 0; i < colors.length; i++) {
            Integer color = Integer.parseInt(colors[i]);
            if (stack.size() >= 2) {
                Integer previous = stack.pop();
                Integer prevprevious = stack.pop();
                if (previous.equals(prevprevious) && previous.equals(stack.peek()) && !previous.equals(color)) {
                    counter += 2;
                    while (!stack.isEmpty() && stack.peek().equals(previous)) {
                        counter += 1;
                        stack.pop();
                    }
                } else {
                    stack.add(prevprevious);
                    stack.add(previous);
                    stack.add(color);
                }
            } else {
                stack.add(color);
            }

        }
        System.out.println(counter);
    }

}
