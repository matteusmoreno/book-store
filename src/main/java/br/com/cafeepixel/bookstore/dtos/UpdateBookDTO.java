package br.com.cafeepixel.bookstore.dtos;

import br.com.cafeepixel.bookstore.domain.Score;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateBookDTO(
        @NotNull
        Long id,
        String title,
        String author,
        String synopsis,
        BigDecimal price,
        String image,
        Score score) {
}
