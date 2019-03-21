package com.albert.rpncalculator.control;

public interface CommandParser {
    void readCmd(String input);
    String getNext();
    int getPosition();
}
