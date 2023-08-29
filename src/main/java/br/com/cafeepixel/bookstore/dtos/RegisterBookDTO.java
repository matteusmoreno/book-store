package br.com.cafeepixel.bookstore.dtos;

import br.com.cafeepixel.bookstore.domain.Score;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegisterBookDTO(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotBlank
        String synopsis,
        @NotNull
        BigDecimal price,
        String image,
        @NotNull
        Score score) {
}
