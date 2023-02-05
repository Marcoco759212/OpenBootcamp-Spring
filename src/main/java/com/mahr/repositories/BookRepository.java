package com.mahr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahr.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
