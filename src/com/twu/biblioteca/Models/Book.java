package com.twu.biblioteca.Models;

import java.util.Objects;

public class Book extends Item{

    public Book(String title, String author, String year){
        setType(ItemType.BOOK);
        setStatus(ItemStatus.AVAILABLE);
        this.name = title;
        this.responsible = author;
        this.year = year;
    }

    public String getTitle() {
        return getName();
    }

    public String getAuthor() {
        return getResponsible();
    }

    public String getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getYear(), book.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getYear());
    }
}
