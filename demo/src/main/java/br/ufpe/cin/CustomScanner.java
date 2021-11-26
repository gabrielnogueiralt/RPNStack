package br.ufpe.cin;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomScanner {
    public ArrayList<Token> readFile(FileReader file) throws Error {
        Scanner in = new Scanner(file);
        ArrayList<Token> tokens = new ArrayList<Token>();
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                Token token = new Token(TokenType.NUM, in.nextLine());
                tokens.add(token);
            } else {
                Token token;
                String operator = in.nextLine();

                if (operator.equals("-")) {
                    token = new Token(TokenType.MINUS, operator);
                    tokens.add(token);
                } else if (operator.equals("+")) {
                    token = new Token(TokenType.PLUS, operator);
                    tokens.add(token);
                } else if (operator.equals("/")) {
                    token = new Token(TokenType.SLASH, operator);
                    tokens.add(token);
                } else if (operator.equals("*")) {
                    token = new Token(TokenType.STAR, operator);
                    tokens.add(token);
                } else {
                    throw new Error("Unexpected character: " + operator);
                }
            }
        }
        return tokens;
    }
}
