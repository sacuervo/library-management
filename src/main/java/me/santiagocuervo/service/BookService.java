package me.santiagocuervo.service;

import java.util.ArrayList;
import java.util.List;

import me.santiagocuervo.exception.NotFoundException;
import me.santiagocuervo.model.Book;

public class BookService {

    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
    }

    public void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByIsbn(String isbn) throws NotFoundException {
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        throw new NotFoundException(String.format("El libro con ISBN '%s', no ha sido encontrado.", isbn));
    }

    public void deleteBook(String isbn) throws NotFoundException {
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return;
            }
        }

        throw new NotFoundException(String.format("El libro con ISBN '%s', no ha podido ser eliminado.", isbn));
    }

}
