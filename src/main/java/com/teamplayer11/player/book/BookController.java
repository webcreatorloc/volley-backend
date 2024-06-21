package com.teamplayer11.player.book;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home() {
        Long myId = Long.valueOf(1);
        String message = "Message";

        //Book book = bookService.getBookById(myId);
        message = "Today is: 21-06  version 1";

        return "The book is named now: " + message;
    }
}
