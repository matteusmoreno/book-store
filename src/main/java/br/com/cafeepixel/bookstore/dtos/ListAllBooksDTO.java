package br.com.cafeepixel.bookstore.dtos;

import br.com.cafeepixel.bookstore.domain.Book;
import br.com.cafeepixel.bookstore.domain.Score;

import java.math.BigDecimal;

public record ListAllBooksDTO(String title, String author, BigDecimal price, Score score) {

    public ListAllBooksDTO(Book book) {
        this(book.getTitle(), book.getAuthor(), book.getPrice(), book.getScore());
    }
}
