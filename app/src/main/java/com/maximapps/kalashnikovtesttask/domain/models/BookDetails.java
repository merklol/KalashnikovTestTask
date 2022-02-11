package com.maximapps.kalashnikovtesttask.domain.models;

import java.util.Date;
import java.util.Objects;

public class BookDetails {
    private final String name;
    private final String authorName;
    private final String description;
    private final Date authorBirthDate;

    public BookDetails(String name, String authorName, String description, Date authorBirthDate) {
        this.name = name;
        this.authorName = authorName;
        this.description = description;
        this.authorBirthDate = authorBirthDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public Date getAuthorBirthDate() {
        return authorBirthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDetails that = (BookDetails) o;
        return name.equals(that.name)
                && authorName.equals(that.authorName)
                && description.equals(that.description)
                && authorBirthDate.equals(that.authorBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorName, description, authorBirthDate);
    }

    public static BookDetails empty() {
        return new BookDetails("", "", "", new Date());
    }
}
