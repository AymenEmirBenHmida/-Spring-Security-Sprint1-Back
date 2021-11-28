package com.example.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.books.entities.Author;

import com.example.books.repos.AuthorRepository;

public class AuthorServiceImpl implements AuthorService {

	
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

	
	
	
}
