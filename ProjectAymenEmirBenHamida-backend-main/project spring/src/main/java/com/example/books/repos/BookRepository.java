package com.example.books.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.books.entities.Author;
import com.example.books.entities.Book;

@RepositoryRestResource(path = "rest")
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByNomBook(String nom);
	List<Book> findByNomBookContains(String nom);
	@Query("select b from Book b where b.nomBook like %?1 and b.prixBook > ?2")
	List<Book> findByNomPrix (String nom, Double prix);
	
	@Query("select b from Book b where b.author = ?1")
	List<Book> findByAuthor (Author author);
	
	List<Book> findByAuthorIdAuthor(Long id);
	List<Book> findByOrderByNomBookAsc();
	
	@Query("select b from Book b order by b.nomBook ASC, b.prixBook DESC")
	List<Book> trierBooksNomsPrix ();
	@Query("select a from Author a where a.idAuthor = ?1")
	Author selectAuther(Long l );
}
