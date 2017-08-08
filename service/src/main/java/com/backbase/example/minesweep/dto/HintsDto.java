package com.backbase.example.minesweep.dto;

/**
 * DTO to store minefield hints.
 * Created by ton on 15/02/17.
 */
public class HintsDto {

    private final String id;

    private final String[] hints;

    public HintsDto(String id, String[] hints) {
        this.id = id;
        this.hints = hints;
    }

    public String getId() {
        return id;
    }

    public String[] getHints() {
        return hints;
    }
}
