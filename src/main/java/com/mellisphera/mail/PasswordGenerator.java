package com.mellisphera.mail;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	
	Random random;
	int nbCharacter = 8;
	Character[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public PasswordGenerator() {
		this.random = new Random();
	}
	
	
	public String getPassword() {
		StringBuilder password = new StringBuilder();
		int i = 0;
		for (i = 0; i < this.nbCharacter; i++) {
			Integer randomInt = this.getRandomInt(this.characters.length + 10);
			if (randomInt < this.characters.length) {
				if (randomInt % 2 == 0) {
					password.append(characters[randomInt]);
				}
				else {
					password.append(Character.toUpperCase(characters[randomInt]));
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
