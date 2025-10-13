package org.example.aop.service;

import org.example.aop.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    Book getBook(int id);
}
