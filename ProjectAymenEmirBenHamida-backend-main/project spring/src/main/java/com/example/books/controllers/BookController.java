package com.example.books.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.books.service.BookService;
import com.example.books.entities.Book;
import com.example.books.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService BookService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("Book", new Book());
	modelMap.addAttribute("mode", "new");
	return "formBook";
	}
	@RequestMapping("/saveBook")
	public String saveBook(@Valid Book Book,
	BindingResult bindingResult)

	{
	if (bindingResult.hasErrors()) return "formBook";
	BookService.saveBook(Book);
	return "formBook";
	}
	
	@RequestMapping("/ListeBooks")
	public String listeBooks(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Book> prods = BookService.getAllBooksParPage(page, size);
	modelMap.addAttribute("Books", prods);

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeBooks";
	}
	
	@RequestMapping("/supprimerBook")
	public String supprimerBook(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	BookService.deleteBookById(id);
	Page<Book> prods = BookService.getAllBooksParPage(page,

	size);

	modelMap.addAttribute("Books", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeBooks";
	}
	
	@RequestMapping("/modifierBook")
	public String editerBook(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Book p= BookService.getBook(id);
	modelMap.addAttribute("Book", p);
	modelMap.addAttribute("mode", "edit");
	return "formBook";
	}
	
	@RequestMapping("/updateBook")
	public String updateBook(@ModelAttribute("Book") Book Book, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		Book.setDatePublication(dateCreation);
		BookService.updateBook(Book);
		List<Book> prods = BookService.getAllBooks();
		modelMap.addAttribute("Books", prods);
		return "listeBooks";
	}
}