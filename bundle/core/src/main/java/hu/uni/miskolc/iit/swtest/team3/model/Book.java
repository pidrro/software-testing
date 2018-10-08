package hu.uni.miskolc.iit.swtest.team3.model;

public class Book {

    private String isbn;
    private String author;
    private String title;
    private String description;
    private String language;
    private Collection<BookInstance> instances;

    public Book(String isbn, String author, String title, String description, String language, Collection<BookInstance> instances) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.description = description;
        this.language = language;
        this.instances = instances;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Collection<BookInstance> getInstances() {
        return instances;
    }

    public void setInstances(Collection<BookInstance> instances) {
        this.instances = instances;
    }
}
