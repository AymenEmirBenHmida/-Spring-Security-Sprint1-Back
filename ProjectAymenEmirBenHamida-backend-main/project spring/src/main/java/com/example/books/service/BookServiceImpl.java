package com.example.books.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.books.entities.Author;
import com.example.books.entities.Book;
import com.example.books.repos.AuthorRepository;
import com.example.books.repos.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository BookRepository;
	
	@Override
	public Book saveBook(Book b) {
		
		return BookRepository.save(b);
	}

	@Override
	public Book updateBook(Book p) {
		return BookRepository.save(p);
	}

	@Override
	public void deleteBook(Book p) {
		BookRepository.delete(p);
		
	}

	@Override
	public void deleteBookById(Long id) {
		BookRepository.deleteById(id);
	}

	@Override
	public Book getBook(Long id) {
		return BookRepository.findById(id).get();
	}

	@Override
	public List<Book> getAllBooks() {
		return BookRepository.findAll();
	}
	
	@Override
	public Page<Book> getAllBooksParPage(int page, int size) {
	return BookRepository.findAll(PageRequest.of(page, size));
	}
	
	
	
	
	@Override
	public List<Book> findByNomBook(String nom) {
	return BookRepository.findByNomBook(nom);
	}
	@Override
	public List<Book> findByNomBookContains(String nom) {
	return BookRepository.findByNomBookContains(nom);
	}
	@Override
	public List<Book> findByNomPrix (String nom, Double prix){
		return BookRepository.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Book> findByAuthor(Author author) {
	return BookRepository.findByAuthor(author);
	}
	@Override
	public List<Book> findByAuthorIdAuthor(Long id) {
	return BookRepository.findByAuthorIdAuthor(id);
	}
	@Override
	public List<Book> findByOrderByNomBookAsc() {
	return BookRepository.findByOrderByNomBookAsc();
	}
	@Override
	public List<Book> trierBooksNomsPrix() {
	return BookRepository.trierBooksNomsPrix();
	}
	
	
	@Autowired
	AuthorRepository AuthorRepository;
	
	@Override
	public Author saveAuthor(Author b) {
		return AuthorRepository.save(b);
	}

	@Override
	public Author updateAuthor(Author p) {
		return AuthorRepository.save(p);
	}

	@Override
	public void deleteAuthor(Author p) {
		AuthorRepository.delete(p);
		
	}

	@Override
	public void deleteAuthorById(Long id) {
		AuthorRepository.deleteById(id);
	}

	@Override
	public Author getAuthor(Long id) {
		return AuthorRepository.findById(id).get();
	}

	@Override
	public List<Author> getAllAuthors() {
		return AuthorRepository.findAll();
	}
	
	@Override
	public Page<Author> getAllAuthorsParPage(int page, int size) {
	return AuthorRepository.findAll(PageRequest.of(page, size));
	}
	
	
	
	
	@Override
	public List<Author> findByNomAuthor(String nom) {
	return AuthorRepository.findByNomAuthor(nom);
	}

	@Override
	public List<Author> findByNomAuthorContains(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author selectAuther(Long l) {
		// TODO Auto-generated method stub
		return  BookRepository.selectAuther(l );
	}

	

	
	
	
	
}
