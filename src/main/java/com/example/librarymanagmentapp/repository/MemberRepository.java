package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface MemberRepository extends CrudRepository<Member,Long> {
//    Member findMemberByMembershipDate(LocalDate date);
//    Member findMemberByTotalBooksCheckedOut(int booksNumber);
}
