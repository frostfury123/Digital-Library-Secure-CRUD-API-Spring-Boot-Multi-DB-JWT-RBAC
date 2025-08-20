package com.example.CRUD_API_Book_Resource.repository.h2;

import com.example.CRUD_API_Book_Resource.model.h2.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



}
