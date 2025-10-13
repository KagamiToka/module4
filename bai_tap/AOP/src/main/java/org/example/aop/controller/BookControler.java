package org.example.aop.controller;

import org.example.aop.entity.Book;
import org.example.aop.service.IBookService;
import org.example.aop.service.IBorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookControler {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowRecordService borrowRecordService;

    @GetMapping(value = "")
    public String books(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String bookDetail(@PathVariable int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "detail";
    }


}
