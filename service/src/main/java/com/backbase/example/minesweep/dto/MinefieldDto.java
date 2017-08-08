package com.backbase.example.minesweep.dto;

/**
 * DTO for minefield data.
 * Created by ton on 09/02/17.
 */
public class MinefieldDto {

    private Integer height;

    private Integer width;

    private String[] minefield;

    public MinefieldDto(Integer height, Integer width, String[] minefield) {
        this.height = height;
        this.width = width;
        this.minefield = minefield;
    }

    public MinefieldDto() {
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setMinefield(String[] minefield) {
        this.minefield = minefield;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public String[] getMinefield() {
        return minefield;
    }
}
