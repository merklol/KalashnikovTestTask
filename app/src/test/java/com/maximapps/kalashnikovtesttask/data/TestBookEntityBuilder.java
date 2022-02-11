package com.maximapps.kalashnikovtesttask.data;

import com.maximapps.kalashnikovtesttask.data.db.models.BookEntity;

@SuppressWarnings("unused")
public class TestBookEntityBuilder {
    private int id = 0;
    private String name = "Zenith";
    private String description = "Description";
    private int authorId = 0;

    public TestBookEntityBuilder id(int value) {
        id = value;
        return this;
    }

    public TestBookEntityBuilder name(String value) {
        name = value;
        return this;
    }

    public TestBookEntityBuilder description(String value) {
        description = value;
        return this;
    }

    public TestBookEntityBuilder authorId(int value) {
        authorId = value;
        return this;
    }

    public BookEntity build() {
        return new BookEntity(id, name, description, authorId);
    }
}
