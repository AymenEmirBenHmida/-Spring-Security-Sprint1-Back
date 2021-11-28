package com.example.books.entities;

import java.util.Date;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBook;
	@NotNull
	private String nomBook;
	private String descriptionBook;
	
	private Double prixBook;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date datePublication;
	
	
	@ManyToOne
	private Author author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Book(String nomBook, String descriptionBook, @PastOrPresent Date datePublication, Double prixBook) {
		super();
		this.nomBook = nomBook;
		this.descriptionBook = descriptionBook;
		this.datePublication = datePublication;
		this.prixBook = prixBook;
	}


	public Double getPrixBook() {
		return prixBook;
	}


	public void setPrixBook(Double prixBook) {
		this.prixBook = prixBook;
	}


	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getNomBook() {
		return nomBook;
	}

	public void setNomBook(String nomBook) {
		this.nomBook = nomBook;
	}

	public String getDescriptionBook() {
		return descriptionBook;
	}

	public void setDescriptionBook(String descriptionBook) {
		this.descriptionBook = descriptionBook;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	
	
	
	
}
