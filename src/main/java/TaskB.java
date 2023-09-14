package src.main.java;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TaskB {

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
        Stack<Character> charStack = new Stack<>();
        char[] charSequence =  sequence.toCharArray();
        int i = 0;
        boolean isCorrect = true;
        while (i < charSequence.length) {
            if (isOpening(charSequence[i])) {
                charStack.add(charSequence[i]);
            } else {
                try {
                    char openingChar = charStack.pop();
                    if (!getSuitable(openingChar).equals(charSequence[i])) {
                        isCorrect = false;
                        break;
                    }
                } catch (EmptyStackException e) {
                    isCorrect = false;
                    break;
                }
            }
            i++;
        }
        if (isCorrect && charStack.empty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}
