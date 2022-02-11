package com.maximapps.kalashnikovtesttask.data;

import com.maximapps.kalashnikovtesttask.data.db.models.AuthorEntity;

import java.util.Date;

@SuppressWarnings("unused")
public class TestAuthorEntityBuilder {
    private int id = 0;
    private String name = "John Doe";
    private Date birthDate = new Date();

    public TestAuthorEntityBuilder id(int value) {
        id = value;
        return this;
    }

    public TestAuthorEntityBuilder name(String value) {
        name = value;
        return this;
    }

    public TestAuthorEntityBuilder birthDate(Date value) {
        birthDate = value;
        return this;
    }

    public AuthorEntity build() {
        return new AuthorEntity(id, name, birthDate);
    }
}