package com.example.books.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import com.example.books.entities.Author;
import com.example.books.entities.Book;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByNomAuthor(String nom);
	List<Book> findByNomAuthorContains(String nom);
	
	
	
	

}
