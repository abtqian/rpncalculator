package com.albert.rpncalculator;

import com.albert.rpncalculator.control.OpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
@Profile("!test")
public class RpncalculatorApplication implements CommandLineRunner {

	@Autowired
	private OpController opController;

	public static void main(String[] args) {
		SpringApplication.run(RpncalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("RPN caculator is running!");
			System.out.println("You can input \'\\q\' or \'exit\' to stop");

			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				if(line.equalsIgnoreCase("\\q") || line.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(opController.ProcessInput(line));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("RPN caculator stopped");
	}
}
