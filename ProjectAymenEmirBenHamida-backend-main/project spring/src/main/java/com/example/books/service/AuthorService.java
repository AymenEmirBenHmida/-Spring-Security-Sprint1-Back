package com.example.books.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.example.books.entities.Author;


public interface AuthorService {

	
	Author saveAuthor(Author b);
	Author updateAuthor(Author p);
	void deleteAuthor(Author p);
	void deleteAuthorById(Long id);
	Author getAuthor(Long id);
	List<Author> getAllAuthors();
	Page<Author> getAllAuthorsParPage(int page, int size);
	List<Author> findByNomAuthor(String nom);
	List<Author> findByNomAuthorContains(String nom);
	
	
}
