package com.backbase.example.minesweep.service;

/**
 * Created by ton on 05/02/17.
 */
public class Minefield {

    private int height;

    private int width;

    private char[][] hints;

    public static Minefield scan(int height, int width, String[] bombs) {
        if (bombs.length != height) {
            throw new ParseException("Provided minefield does not match provided height");
        }

        Minefield minefield = new Minefield(height, width);

        for (int h = 0; h < height; h++) {
            if (bombs[h].length() != width) {
                throw new ParseException("All provided lines should match provided length");
            }

            char[] markers = bombs[h].toCharArray();
            for (int w = 0; w < width; w++) {
                if (markers[w] == '*') {
                    minefield.placeBomb(h,w);
                }
            }
        }

        return minefield;
    }

    public String[] getHints() {
        String[] result = new String[this.height];
        for (int h = 0; h < this.height; h++) {
            result[h] = new String(this.hints[h]);
        }
        return result;
    }

    private Minefield(int height, int width) {
        this.height = height;
        this.width = width;
        this.hints = new char[height][width];
        initializeHints();
    }

    private void placeBomb(int row, int col) {
        this.hints[row][col] = '*';
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                incrementCount(row + dr, col + dc);
            }
        }
    }

    private void incrementCount(int row, int col) {
        if (row < 0 || row >= height) {
            return;
        }
        if (col < 0 || col >= width) {
            return;
        }
        if (this.hints[row][col] == '*') {
            return;
        }
        this.hints[row][col]++;
    }

    private void initializeHints() {
        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                this.hints[h][w] = '0';
            }
        }
    }
}
