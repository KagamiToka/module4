package org.example.aop.service;

import org.example.aop.entity.Book;
import org.example.aop.entity.BorrowRecord;
import org.example.aop.exception.BookNotAvailableException;
import org.example.aop.exception.InvalidBorrowCodeException;
import org.example.aop.repository.IBookRepository;
import org.example.aop.repository.IBorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRecordService implements IBorrowRecordService{
    @Autowired
    private IBorrowRecordRepository borrowRecordRepository;

    @Autowired
    private IBookRepository bookRepository;


    @Override
    public String borrowBook(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("Sách đã hết");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String borrowCode = String.valueOf((int)(Math.random() * 90000 + 10000));
        BorrowRecord record = new BorrowRecord();
        record.setBorrowCode(borrowCode);
        record.setBookId(bookId);
        record.setReturned(false);
        borrowRecordRepository.save(record);

        return borrowCode;
    }

    @Override
    public void returnBook(String borrowCode) {
        BorrowRecord record = borrowRecordRepository.findById(borrowCode)
                .orElseThrow(() -> new InvalidBorrowCodeException("Mã mượn không hợp lệ"));
        if (record.isReturned()) {
            throw new InvalidBorrowCodeException("Mã này đã được trả rồi");
        }

        Book book = bookRepository.findById(record.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        record.setReturned(true);
        borrowRecordRepository.save(record);
    }
}
