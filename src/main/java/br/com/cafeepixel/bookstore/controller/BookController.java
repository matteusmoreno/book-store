package br.com.cafeepixel.bookstore.controller;

import br.com.cafeepixel.bookstore.domain.Book;
import br.com.cafeepixel.bookstore.dtos.BookDetailsDTO;
import br.com.cafeepixel.bookstore.dtos.ListAllBooksDTO;
import br.com.cafeepixel.bookstore.dtos.RegisterBookDTO;
import br.com.cafeepixel.bookstore.dtos.UpdateBookDTO;
import br.com.cafeepixel.bookstore.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity registerBook(@RequestBody @Valid RegisterBookDTO data, UriComponentsBuilder uriBuilder) {
        var book = new Book(data);
        repository.save(book);

        var uri = uriBuilder.path("/bookstore/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(new BookDetailsDTO(book));
    }

    @GetMapping("/listbooks")
    public ResponseEntity<Page<ListAllBooksDTO>> listBooks(@PageableDefault(size = 10, sort = {"title"})Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ListAllBooksDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/bookdetails/{title}")
    public ResponseEntity bookDetails(@PathVariable String title) {
        var book = repository.getReferenceByTitle(title);

        return ResponseEntity.ok().body(new BookDetailsDTO(book));
    }

    @PutMapping("/updatebook")
    @Transactional
    public ResponseEntity updateBook(@RequestBody @Valid UpdateBookDTO data) {
        var book = repository.getReferenceById(data.id());
        book.updateBook(data);

        return ResponseEntity.ok().body(new BookDetailsDTO(book));
    }

    @DeleteMapping("/desactivatebook/{id}")
    @Transactional
    public ResponseEntity desactivateBook(@PathVariable Long id) {
        var book = repository.getReferenceById(id);
        book.desactivateBook();

        return ResponseEntity.noContent().build();
    }
}
