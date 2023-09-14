package src.main.java;


import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TaskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Integer> charStack = new Stack<>();
        List<String> inputList = List.of(input.split(" "));
        for (String inputSymbol: inputList) {
            if (inputSymbol.equals("+") || inputSymbol.equals("-") || inputSymbol.equals("*")) {
                switch (inputSymbol) {
                    case "+":
                        charStack.add(charStack.pop() + charStack.pop());
                        break;
                    case "-":
                        int a = charStack.pop();
                        charStack.add(charStack.pop() - a);
                        break;
                    case "*":
                        charStack.add(charStack.pop() * charStack.pop());
                }
            } else {
                charStack.add(Integer.parseInt(inputSymbol));
            }
        }

        System.out.println(charStack.pop());

    }
}
