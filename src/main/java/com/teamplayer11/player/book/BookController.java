package com.teamplayer11.player.book;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Book book = bookService.getBookById(myId);
        message = book.getName();

        return "The book is named now: " + message;
    }
}
