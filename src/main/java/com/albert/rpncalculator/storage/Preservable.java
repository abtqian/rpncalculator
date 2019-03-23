package com.albert.rpncalculator.storage;

public interface Preservable {

    void save();

    void load();

    void recovery();

}
