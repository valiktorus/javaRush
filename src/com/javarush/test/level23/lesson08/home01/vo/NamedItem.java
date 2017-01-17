package com.javarush.test.level23.lesson08.home01.vo;

import com.javarush.test.level23.lesson08.home01.AbstractDbSelectExecutor;

public class NamedItem extends AbstractDbSelectExecutor {
    private int id;
    private String name;
    private String description;

    public NamedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getQuery() {
        return null;
    }
}
