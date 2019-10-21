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



/**
 * 
 */
package com.mellisphera.security.message.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author epa
 *
 */
public class SignUpForm {

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

  
    
    public SignUpForm(@NotBlank String username, @NotBlank @Size(max = 60) @Email String email, Set<String> role,
			@NotBlank @Size(min = 6, max = 40) String password) {
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
    }
}
