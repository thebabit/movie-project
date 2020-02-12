package com.revature.models;

public enum  UserRole {
    ADMIN("Admin"), DEV ("DEV"), BASIC_USER("BASIC USER"), LOCKED("Locked");
    private String rolewname;
    UserRole (String name){
        this.rolewname =name;
    }

    @Override
    public String toString(){
        return this.rolewname;
    }
}
