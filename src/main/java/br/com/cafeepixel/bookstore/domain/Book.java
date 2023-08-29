package br.com.cafeepixel.bookstore.domain;

import br.com.cafeepixel.bookstore.dtos.RegisterBookDTO;
import br.com.cafeepixel.bookstore.dtos.UpdateBookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Book")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String synopsis;
    private BigDecimal price;
    private String image;
    @Enumerated(EnumType.STRING)
    private Score score;
    private Boolean status;

    public Book(RegisterBookDTO data) {
        this.title = data.title();
        this.author = data.author();
        this.synopsis = data.synopsis();
        this.price = data.price();
        this.image = data.image();
        this.score = data.score();
        this.status = true;
    }

    public void updateBook(UpdateBookDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.author() != null) {
            this.author = data.author();
        }
        if (data.synopsis() != null) {
            this.synopsis = data.synopsis();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
        if (data.image() != null) {
            this.image = data.image();
        }
        if (data.score() != null) {
            this.score = data.score();
        }
    }

    public void desactivateBook() {
        this.status = false;
    }
}
