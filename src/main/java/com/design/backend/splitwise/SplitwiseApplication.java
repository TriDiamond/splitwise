package com.design.backend.splitwise;

import com.design.backend.splitwise.commands.Command;
import com.design.backend.splitwise.commands.CommandExecutor;
import com.design.backend.splitwise.commands.LoginUserCommand;
import com.design.backend.splitwise.commands.RegisterUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	private static Scanner scanner = new Scanner(System.in);
	private CommandExecutor	 commandExecutor = new CommandExecutor(new ArrayList<>());

	@Override
	public void run(String... args) throws Exception {
		String input = scanner.nextLine();
        commandExecutor.add(new RegisterUserCommand());
		commandExecutor.add(new LoginUserCommand());
		commandExecutor.execute(input);
	}

	public static void main(String[] args) {

		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
