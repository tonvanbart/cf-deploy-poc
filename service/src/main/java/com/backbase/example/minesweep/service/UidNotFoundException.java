package com.backbase.example.minesweep.service;

/**
 * Exception signalling that no hints were found.
 * Created by ton on 19/02/17.
 */
public class UidNotFoundException extends RuntimeException {

    /**
     * Create a new instance, specifying that no hints were found for the provided uid.
     * @param uuid the uuid.
     */
    public UidNotFoundException(String uuid) {
        super(String.format("No hints found for id '%s'", uuid));
    }
}
