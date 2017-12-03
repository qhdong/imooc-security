package com.imooc.exception;

public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("User not exist");
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
