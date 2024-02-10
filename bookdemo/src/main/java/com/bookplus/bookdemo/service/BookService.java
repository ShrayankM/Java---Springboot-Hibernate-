package com.bookplus.bookdemo.service;

import com.bookplus.bookdemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findBookByAuthorName(String authorName);

    void addBookToDB(Book book);
}
