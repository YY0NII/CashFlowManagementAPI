package com.codediff.ocr.api.CashFlowManagementAPI.exceptions;

public class ReceiptNotFoundException extends RuntimeException{

    ReceiptNotFoundException(Long id) {
    super("could not find receipt" + id);
}
}
