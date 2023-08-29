package br.com.cafeepixel.bookstore.dtos;

import br.com.cafeepixel.bookstore.domain.Book;
import br.com.cafeepixel.bookstore.domain.Score;

import java.math.BigDecimal;

public record BookDetailsDTO(
        Long id,
        String title,
        String author,
        String synopsis,
        BigDecimal price,
        String image,
        Score score,
        Boolean status) {

    public BookDetailsDTO(Book book) {
        this(book.getId(), book.getTitle(), book.getAuthor(), book.getSynopsis(), book.getPrice(),
                book.getImage(), book.getScore(), book.getStatus());
    }
}
