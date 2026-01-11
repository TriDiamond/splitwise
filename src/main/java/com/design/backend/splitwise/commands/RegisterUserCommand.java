package com.design.backend.splitwise.commands;

public class RegisterUserCommand implements Command {
    @Override
    public boolean match(String input) {
        String[] words = input.split(" ");
        return words[0].equals("Register") && words.length == 3;
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        System.out.println("Executing user Registration ");
    }
}
