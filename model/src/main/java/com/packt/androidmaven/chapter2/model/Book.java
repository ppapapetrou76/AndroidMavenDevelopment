package com.packt.androidmaven.chapter2.model;

public class Book {

    private Integer id;
    private String title;
    private String format;
    private String color;
    private Integer numberOfPages;
    private Boolean brandNew;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", format='" + format + '\'' +
                ", color='" + color + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", brandNew=" + brandNew +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Boolean isBrandNew() {
        return brandNew;
    }

    public void setBrandNew(Boolean brandNew) {
        this.brandNew = brandNew;
    }

}