package br.ufpe.cin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class RPNStack {
    public static void main(String[] args) {
        CustomScanner scan = new CustomScanner();

        Stack<Integer> stack = new Stack<>();

        try {
            ArrayList<Token> tokens = scan.readFile(new FileReader("demo/src/Calc1.stk"));
            try {
                
            } catch (Error e) {
                throw new Error();
            }
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).type == TokenType.NUM) {
                    stack.push(Integer.parseInt(tokens.get(i).lexeme));
                } else {
                    int value1 = stack.pop(), value2 = stack.pop();
                    
                    if (tokens.get(i).type == TokenType.MINUS) {
                        stack.push(value1 - value2);
                    } else if (tokens.get(i).type == TokenType.PLUS) {
                        stack.push(value1 + value2);
                    } else if (tokens.get(i).type == TokenType.SLASH) {
                        stack.push(value1 / value2);
                    } else {
                        stack.push(value1 * value2);
                    }
                }
            }
    
            System.out.println(stack.get(0));
        }  catch (FileNotFoundException e) {
            System.out.println("File not found :/.");
            e.printStackTrace();
          }


    }
}
