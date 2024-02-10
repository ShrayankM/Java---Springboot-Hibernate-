package com.bookplus.bookdemo.controller;

import com.bookplus.bookdemo.model.Book;
import com.bookplus.bookdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{authorName}", method = RequestMethod.GET)
    public String getAuthorsBooks(@PathVariable ("authorName") String authorName, Model model) {
        List<Book> booksList = bookService.findBookByAuthorName(authorName);
        model.addAttribute("booksList", booksList);
        return "booksList";
    }

    @RequestMapping(value = "/{authorName}", method = RequestMethod.POST)
    public String addBook(@PathVariable ("authorName") String authorName, Book book) {
        book.setAuthorName(authorName);
        bookService.addBookToDB(book);
        return "redirect:/{authorName}";
    }
}
