package com.example.CRUD_API_Book_Resource.service;

import com.example.CRUD_API_Book_Resource.model.h2.Book;
import com.example.CRUD_API_Book_Resource.repository.h2.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

        @Autowired
        private BookRepository repo;

        @Autowired
        private AuditLogService auditLogService;

        public List<Book> getBooks(){

            return repo.findAll();
        }

        public Book getBookById(long id){
            return repo.findById(id).orElse(null);
        }

        public Book addBook(Book book){
            Book saved = repo.save(book);
            auditLogService.logCurrentUser("CREATE_BOOK", saved.getId());
            return saved;
        }

        public Book updateBook(Book book){
             Book saved = repo.save(book);
             auditLogService.logCurrentUser("UPDATE_BOOK", saved.getId());
             return saved;
        }

        public void deleteBook(long id){
            repo.deleteById(id);
            auditLogService.logCurrentUser("DELETE_BOOK", id);
        }
}
