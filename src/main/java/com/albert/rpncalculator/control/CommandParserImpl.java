package com.albert.rpncalculator.control;

import org.springframework.stereotype.Component;

@Component
public class CommandParserImpl implements CommandParser {

    private String input = null;
    private int currentp = 0;
    private int nextp = 0;


    @Override
    public void readCmd(String input) {
        this.input = input;
        currentp = 0;
        nextp = 0;
    }

    @Override
    public String getNext() {
        currentp = nextp;
        while(currentp < input.length() && input.charAt(currentp) == ' ') {
            currentp++;
        }
        if(currentp == input.length()) {
            return null;
        }

        nextp = currentp + 1;
        while(nextp < input.length() && input.charAt(nextp) != ' ') {
            nextp++;
        }
        return input.substring(currentp, nextp);
    }

    @Override
    public int getPosition() {
        return currentp + 1;
    }
}
