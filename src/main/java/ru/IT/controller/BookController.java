package ru.IT.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.IT.DTO.BookDTO;
import ru.IT.entity.Book;
import ru.IT.services.BookServiceImpl;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @GetMapping("/books/{id}")
    BookDTO getBookById(@PathVariable("id") Long id) {
        return bookServiceImpl.getBookById(id);
    }

    @PostMapping("/v1/books")
    public Book addNewBook(@RequestBody Book book) {
        return bookServiceImpl.addNewBook(book);
    }

    @PostMapping("/v2/books")
    public Book addNewBook(@RequestBody BookDTO bookDTO) {
        return bookServiceImpl.addNewBook(bookDTO);
    }

    @PutMapping("/books")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookServiceImpl.updateBook(bookDTO));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookServiceImpl.deleteBook(id));
    }
}




