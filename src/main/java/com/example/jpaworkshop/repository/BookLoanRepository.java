package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.BookLoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    Optional<BookLoan> findBookLoanByBorrower_Id(int borrowerId);

    Optional<BookLoan> findBookLoanByBook_Id(int bookId);

    List<BookLoan> findBookLoansByReturned(boolean returned);

    List<BookLoan> findBookLoansByDueDateIsAfter(LocalDate dueDateAfter);

    List<BookLoan> findBookLoansByLoanDateBetween(LocalDate loanDateAfter, LocalDate loanDateBefore);

    Optional<BookLoan> findBookLoanById(int id);

}