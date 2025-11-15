package com.example.library.controller;

import com.example.library.dto.BookRequestDTO;
import com.example.library.dto.BookResponseDTO;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // Create book
    @PostMapping
    public BookResponseDTO add(@RequestBody BookRequestDTO dto) {
        return service.addBook(dto);
    }

    // Get all books
    @GetMapping
    public List<BookResponseDTO> getAll() {
        return service.getAllBooks();
    }

    // Get single book
    @GetMapping("/{id}")
    public BookResponseDTO getById(@PathVariable Long id) {
        return service.getBook(id);
    }

    // Update
    @PutMapping("/{id}")
    public BookResponseDTO update(@PathVariable Long id, @RequestBody BookRequestDTO dto) {
        return service.updateBook(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted successfully!";
    }
}
