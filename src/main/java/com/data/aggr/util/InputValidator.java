package com.data.aggr.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class InputValidator {

    public static void validate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasErrors()) {
            return;
        }
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder messageBuilder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            messageBuilder.append(fieldError.getField());
            messageBuilder.append(" ");
            messageBuilder.append(fieldError.getDefaultMessage());
            messageBuilder.append("; ");
        }
        throw new Exception(messageBuilder.toString().trim());
    }
}
