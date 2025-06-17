package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.BookLoan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Modifying //Allows the use of update and insert
    @Query(value = "UPDATE BookLoan AS bl  set bl.returned = false WHERE bl.id = :bookLoanId ")
    Optional<BookLoan> markBookLoanFalseById(@Param("bookLoanId") int bookLoanId);
//
}