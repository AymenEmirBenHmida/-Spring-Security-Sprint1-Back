package com.example.books.restontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entities.Author;
import com.example.books.entities.Book;
import com.example.books.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookRESTController {
@Autowired
BookService BookService;
@RequestMapping(method = RequestMethod.GET)
public List<Book> getAllBooks() {
return BookService.getAllBooks();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Book getBookById(@PathVariable("id") Long id) {
return BookService.getBook(id);

}

@RequestMapping(method = RequestMethod.POST)
public Book createBook(@RequestBody Book Book) {
return BookService.saveBook(Book);


}

@RequestMapping(method = RequestMethod.PUT)
public Book updateBook(@RequestBody Book Book) {
return BookService.updateBook(Book);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteBook(@PathVariable("id") Long id)
{
BookService.deleteBookById(id);
}

@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Book> getBooksAuthorIdAuthor(@PathVariable("idCat") Long idCat) {
return BookService.findByAuthorIdAuthor(idCat);
}
@RequestMapping(value="author",method = RequestMethod.GET)
public List<Author> getAllAuthors() {
return BookService.getAllAuthors();
}
@RequestMapping(value="author/{id}",method = RequestMethod.GET)
public Author getAuthorById(@PathVariable("id") Long id) {
return BookService.getAuthor(id);

}

@RequestMapping(value="author",method = RequestMethod.POST)
public Author createAuthor(@RequestBody Author Author) {
return BookService.saveAuthor(Author);
}

@RequestMapping(value="author",method = RequestMethod.PUT)
public Author updateAuthor(@RequestBody Author Author) {
return BookService.updateAuthor(Author);
}

@RequestMapping(value="author/{id}",method = RequestMethod.DELETE)
public void deleteAuthor(@PathVariable("id") Long id)
{
BookService.deleteAuthorById(id);
}


}