package com.ai.utills;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;

public class Generator {

	
	public StringBuilder randomGenerator() {

//		System.out.println("Hello, How Are You !");

// Uppercase Alphabet
		String[] alphabetsCapital = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

// Lowercase Alphabet
		String[] alphabetsSmall = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };

		int[] integerValue = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		String result = String.join("", alphabetsCapital) + String.join("", alphabetsSmall)
				+ Arrays.stream(integerValue).mapToObj(String::valueOf).collect(Collectors.joining());

//		System.out.println("result " + result);

		StringBuilder randomValues = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int randomIndex = ThreadLocalRandom.current().nextInt(result.length());

			char randomValue = result.charAt(randomIndex);

			randomValues.append(randomValue);
		}
		
		 

//		System.out.println("Random value: " + randomValues);
		
		return randomValues;

	}
}
