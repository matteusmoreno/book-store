package br.com.cafeepixel.bookstore.repository;

import br.com.cafeepixel.bookstore.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByStatusTrue(Pageable pageable);

    Book getReferenceByTitle(String title);
}
