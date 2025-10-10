package org.example.aop.repository;

import org.example.aop.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRecordRepository extends JpaRepository<BorrowRecord,String> {
}
