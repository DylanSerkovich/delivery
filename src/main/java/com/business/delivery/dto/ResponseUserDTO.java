package com.business.delivery.dto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ResponseUserDTO {

    private boolean validated;

    private boolean exists;

    public boolean isValidated() {  return validated; }

    public boolean isExists() { return exists;}

    private Map<String, String> errorMessages = new HashMap<>();

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void setErrors(BindingResult result) {
        for (FieldError error : result.getFieldErrors()) {
            String key = error.getField();
            String value = error.getDefaultMessage();
            this.errorMessages.put(key, value);
            System.out.println("iteracion");
        }
    }

    public void AddError(String key, String value){
        this.errorMessages.put(key, value);
    }
}
