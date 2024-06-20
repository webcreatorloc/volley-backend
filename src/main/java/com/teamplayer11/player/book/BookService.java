package com.teamplayer11.player.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        System.out.println("Book with id: {} doesn't exist " + id);
        return null;
    }
}

