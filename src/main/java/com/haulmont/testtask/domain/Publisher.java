package com.haulmont.testtask.domain;

public enum Publisher {

    MOSCOW("Москва"),
    PETER("Питер"),
    OREILLY("O’Reilly");

    private String name;

    Publisher(String name) {
        this.name = name;
    }

}
