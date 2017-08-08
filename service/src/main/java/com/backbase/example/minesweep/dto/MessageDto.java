package com.backbase.example.minesweep.dto;

/**
 * DTO used to returh error messages.
 * Created by ton on 12/02/17.
 */
public class MessageDto {

    private String exception;

    private String message;

    public MessageDto() {
    }

    public MessageDto(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
