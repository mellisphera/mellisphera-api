package com.mellisphera.mail;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	
	private Random random;
	private static final int NB_CARACTERE = 8;
	private static final Character[] CHARACTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public PasswordGenerator() {
		this.random = new Random();
	}
	
	
	public String getPassword() {
		StringBuilder password = new StringBuilder();
		int i = 0;
		for (i = 0; i < NB_CARACTERE; i++) {
			Integer randomInt = this.getRandomInt(CHARACTERS.length + 10);
			if (randomInt < CHARACTERS.length) {
				if (randomInt % 2 == 0) {
					password.append(CHARACTERS[randomInt]);
				}
				else {
					password.append(Character.toUpperCase(CHARACTERS[randomInt]));
				}
			}
			else {
				password.append(randomInt.toString());
			}
		}
		return password.toString();
	}
	
	int getRandomInt(int size){
		return this.random.nextInt(size);
	}
}
