package com.MashuMashu.springbootlibrary.dao;

import com.MashuMashu.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book, Long> {
}
