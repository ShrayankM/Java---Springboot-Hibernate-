package com.bookplus.bookdemo.service.impl;

import com.bookplus.bookdemo.dao.BookRepository;
import com.bookplus.bookdemo.model.Book;
import com.bookplus.bookdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findBookByAuthorName(String authorName) {

        List<Book> bookList = bookRepository.findByAuthorName(authorName);
        return bookList != null ? bookList : new ArrayList<>();
    }

    @Override
    public void addBookToDB(Book book) {
        bookRepository.save(book);
    }
}
