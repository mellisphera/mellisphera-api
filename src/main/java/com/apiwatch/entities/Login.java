/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apiwatch.entities;

/**
 *
 * @author mickael
 */
public class Login {
    
    private String username;
    private String password;
    
    public Login(){
        super();
    }
    public Login(String username , String password){
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "Username : "+this.username+" ,Password : "+this.password;
    }
}
