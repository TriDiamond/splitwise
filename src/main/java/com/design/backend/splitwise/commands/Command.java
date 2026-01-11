package com.design.backend.splitwise.commands;

public interface Command {

    boolean match(String input);

    void execute(String input);
}
