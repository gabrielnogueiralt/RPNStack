package br.ufpe.cin;

import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.Stack;

public class RPNStack 
{
    public static void main( String[] args ) {
        Stack<Integer> stack = new Stack<>();		
        try {
            File rpnStack = new File("C:/Users/Gabriel/Documents/CIn/Compiladores/RPNStacker/demo/src/main/java/br/ufpe/cin/Calc1.stk");
            Scanner reader = new Scanner(rpnStack);
            while(reader.hasNextLine()) {
                if (reader.hasNextInt()) {
                    stack.push(reader.nextInt());
                } else {
                    char operator = reader.next().charAt(0);
                    int value1 = stack.pop(), value2 = stack.pop();
                    if (operator == '-') stack.push(value1 - value2);
                    else if (operator == '+') stack.push(value1 + value2);
                    else if (operator == '/') stack.push(value1 / value2);
                    else if (operator == '*') stack.push(value1 * value2);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
		System.out.println(stack.get(0));
    }
}
