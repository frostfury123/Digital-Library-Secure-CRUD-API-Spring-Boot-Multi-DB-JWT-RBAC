package com.example.CRUD_API_Book_Resource.repository.postgres;

import com.example.CRUD_API_Book_Resource.model.postgres.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{



}
