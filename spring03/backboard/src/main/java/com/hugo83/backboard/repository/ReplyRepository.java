package com.hugo83.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo83.backboard.entity.Reply;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    
}
