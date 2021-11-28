package com.example.Books;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.books.entities.Author;
import com.example.books.entities.Book;
import com.example.books.repos.BookRepository;
import com.example.books.service.BookService;

@SpringBootTest
class BooksApplicationTests {
	@Autowired
	private BookRepository BookRepository;
	@Autowired
	private BookService BookService;

	@Test
	public void testCreateBook() {
		Book prod = new Book("sunn", "a great book", new Date(), 120.23);
		BookRepository.save(prod);
	}

	@Test
	public void testUpdateBook() {
		Book b = BookRepository.findById(14L).get();
		b.setPrixBook(10.0);
		BookRepository.save(b);
	}

	@Test
	public void testDeleteBook() {
		BookRepository.deleteById(1L);
	}

	@Test
	public void testFindAllBooks() {
		List<Book> prods = BookRepository.findAll();

		for (Book p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomBook() {
		List<Book> prods = BookRepository.findByNomBook("sunn");

		for (Book p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomBookContains() {
		List<Book> prods = BookRepository.findByNomBookContains("unn");

		for (Book p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Book> prods = BookRepository.findByNomPrix("sunn", 120.0);
		for (Book p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByAuthor() {
		Author cat = new Author();
		cat.setIdAuthor(1L);
		List<Book> prods = BookRepository.findByAuthor(cat);
		for (Book p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByAuthoridAuthor() {
		
		List<Book> prods = BookRepository.findByAuthorIdAuthor(2L);
		for (Book p : prods) {
			System.out.println(p.toString());
		}

	}

	@Test
	public void testfindByOrderByNomBookAsc() {
		List<Book> prods =

				BookRepository.findByOrderByNomBookAsc();
		for (Book p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testTrierBooksNomsPrix() {
		List<Book> prods = BookRepository.trierBooksNomsPrix();
		for (Book p : prods) {
			System.out.println(p);
		}

	}
}
