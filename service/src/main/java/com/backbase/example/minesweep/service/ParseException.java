package com.backbase.example.minesweep.service;

/**
 * Custom exception type to signal unparseable input.
 * Created by ton on 12/02/17.
 */
public class ParseException extends RuntimeException {

    public ParseException(String message) {
        super(message);
    }
}
