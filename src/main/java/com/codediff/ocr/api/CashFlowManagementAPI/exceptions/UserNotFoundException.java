package com.codediff.ocr.api.CashFlowManagementAPI.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("could not find User" + id);
    }

}
