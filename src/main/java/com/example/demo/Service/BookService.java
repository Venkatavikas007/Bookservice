package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public List<Book> getAllBooks(){
		return repository.findAll();
	}
	
	public Optional<Book> getBookById(Long id){
		return repository.findById(id);
	}
	
	public Book createBook(Book book) {
		return repository.save(book);
	}
	
	public Book updateBook(Long id, Book bookDetails) {
		Book book = repository.findById(id).orElseThrow( () -> new RuntimeException("Book not Found"));
		
		book.setTitle(bookDetails.getTitle());
		book.setAuother(bookDetails.getAuother());
		book.setPublishedYear(bookDetails.getPublishedYear());
		book.setGenre(bookDetails.getGenre());
		 return repository.save(book);
	}
	
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
	
}
