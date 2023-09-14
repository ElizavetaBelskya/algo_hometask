package src.main.java;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TaskC {

    public static boolean isOpening(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    public static Character getSuitable(char a) {
        switch (a) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return null;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sequence = sc.nextLine();
        int counter = 0;
        Stack<Character> charStack = new Stack<>();
        char[] charSequence =  sequence.toCharArray();
        int i = 0;
        while (i < charSequence.length) {
            if (isOpening(charSequence[i])) {
                charStack.add(charSequence[i]);
            } else {
                try {
                    char openingChar = charStack.peek();
                    if (getSuitable(openingChar).equals(charSequence[i])) {
                        charStack.pop();
                    } else {
                        counter++;
                    }
                } catch (EmptyStackException e) {
                    counter++;
                }
            }
            i++;
        }

        System.out.println(counter + charStack.size());
    }

}
