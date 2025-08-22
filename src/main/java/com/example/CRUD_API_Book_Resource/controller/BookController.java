package com.example.CRUD_API_Book_Resource.controller;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.CRUD_API_Book_Resource.model.h2.Book;
import com.example.CRUD_API_Book_Resource.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService service;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

       return new ResponseEntity<>(service.getBooks(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('view_books')")
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){

        Book book1 = service.getBookById(id);

        if (book1 != null) {
            return new ResponseEntity<>(book1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('create_books')")
    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
           try {
               Book book1 = service.addBook(book);
               return new ResponseEntity<>(book1, HttpStatus.CREATED);
           }
           catch(Exception e) {
               return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }

    @PreAuthorize("hasAuthority('update_books')")
    @PutMapping("/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
            try{
                Book book1 = service.updateBook(book);
                return new ResponseEntity<>(book1,HttpStatus.OK);
            }
            catch(Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @PreAuthorize("hasAuthority('delete_books')")
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deletebook(@PathVariable long id) {

        Book book1 = service.getBookById(id);

        if (book1 != null) {
            service.deleteBook(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
