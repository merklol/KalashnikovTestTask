package com.maximapps.kalashnikovtesttask.data;

import com.maximapps.kalashnikovtesttask.domain.models.BookDetails;

import java.util.Date;

@SuppressWarnings("unused")
public class TestBookDetailsBuilder {
    private String name = "Zenith";
    private String authorName = "John Doe";
    private String description = "Description";
    private Date birthDate = new Date();

    public TestBookDetailsBuilder name(String value) {
        name = value;
        return this;
    }

    public TestBookDetailsBuilder authorName(String value) {
        authorName = value;
        return this;
    }

    public TestBookDetailsBuilder description(String value) {
        description = value;
        return this;
    }

    public TestBookDetailsBuilder birthDate(Date value) {
        birthDate = value;
        return this;
    }

    public BookDetails build() {
        return new BookDetails(name, authorName, description, birthDate);
    }
}