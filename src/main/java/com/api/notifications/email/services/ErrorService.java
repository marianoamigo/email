package com.api.notifications.email.services;

public class ErrorService extends Exception{
    public ErrorService(String message) {
        super(message);
    }
}
