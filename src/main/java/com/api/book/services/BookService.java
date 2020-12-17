package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.book.dao.BookRepository;
import com.api.book.models.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(12, "java complete reference", "XYZ"));
//		list.add(new Book(36, "Head First TO Java", "ABC"));
//		list.add(new Book(125, "Think in java", "LMN"));
//	}

	// get all books
	public List<Book> getAllBooks() {

		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get book by Id
	public Book getBookById(int id) {

		Book book = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	// adding book
	public Book addBook(Book b) {
//		list.add(b);
		Book result = bookRepository.save(b);
		return result;
	}

	// delete book
	public void deleteBook(int bid) {
//		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		this.bookRepository.deleteById(bid);
	}

	// update
	public void updatebook(Book book, int id) {
//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookRepository.save(book);
		
	}

}
