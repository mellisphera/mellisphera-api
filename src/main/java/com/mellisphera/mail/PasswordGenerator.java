/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



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
