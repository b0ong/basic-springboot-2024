package com.hugo83.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo83.backboard.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    
}
