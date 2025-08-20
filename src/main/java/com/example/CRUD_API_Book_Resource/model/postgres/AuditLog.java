package com.example.CRUD_API_Book_Resource.model.postgres;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "Audit_Logs")
@NoArgsConstructor
@Data
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Actor user id (from Postgres Users table). May be null if unknown (e.g., OAuth2 principal not in Users).
    @Column(name = "user_id")
    private Integer userId;

    // e.g., CREATE_BOOK, UPDATE_BOOK, DELETE_BOOK, CREATE_USER
    @Column(nullable = false)
    private String action;

    // Book id from H2 (no FK across DBs)
    @Column(name = "book_id")
    private Long bookId;

    @Column(nullable = false)
    private Instant timestamp = Instant.now();

    public AuditLog(Integer userId, String action, Long bookId){

            this.userId = userId;
            this.action = action;
            this.bookId = bookId;
            this.timestamp = Instant.now();

    }

}
