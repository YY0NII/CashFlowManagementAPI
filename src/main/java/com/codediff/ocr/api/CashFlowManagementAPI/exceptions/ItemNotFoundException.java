package com.codediff.ocr.api.CashFlowManagementAPI.exceptions;

public class ItemNotFoundException extends RuntimeException {
    ItemNotFoundException(Long id) {
        super("could not find item" + id);
    }
}
