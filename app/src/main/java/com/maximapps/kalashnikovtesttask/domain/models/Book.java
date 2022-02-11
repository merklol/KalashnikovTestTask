package com.maximapps.kalashnikovtesttask.domain.models;

import java.util.Objects;

public class Book {
    private final int id;
    private final String name;
    private final String description;

    public Book(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && name.equals(book.name) && description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
