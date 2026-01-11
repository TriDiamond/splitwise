package com.design.backend.splitwise.commands;

public class LoginUserCommand implements Command{

    @Override
    public boolean match(String input) {
        String[] words = input.split(" ");
        return words[0].equals("Login") && words.length == 3;
    }

    @Override
    public void execute(String input) {
        System.out.println("Login User Command Executing");
    }
}
