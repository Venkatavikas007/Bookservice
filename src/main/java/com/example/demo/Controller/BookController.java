package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return service.getAllBooks();
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id){
		return ResponseEntity.ok(service.getBookById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book created = service.createBook(book);
		return ResponseEntity.status(201).body(created);
	}
	

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(service.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
	
}
