package com.MashuMashu.springbootlibrary.dao;

import com.MashuMashu.springbootlibrary.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
