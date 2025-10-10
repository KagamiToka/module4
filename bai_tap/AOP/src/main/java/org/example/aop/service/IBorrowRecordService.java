package org.example.aop.service;

public interface IBorrowRecordService {
    String borrowBook(int bookId);
    void returnBook(String borrowCode);
}
