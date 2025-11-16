package com.example.library.service;

import com.example.library.dto.BookRequestDTO;
import com.example.library.dto.BookResponseDTO;
import com.example.library.entity.Book;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    private BookResponseDTO mapToDTO(Book book) {
        return new BookResponseDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO dto) {
        Book book = new Book(dto.getTitle(), dto.getAuthor(), dto.getPrice());
        return mapToDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return mapToDTO(book);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO dto) {
        Book book = bookRepository.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        return mapToDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
