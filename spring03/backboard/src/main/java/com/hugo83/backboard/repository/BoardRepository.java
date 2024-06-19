package com.hugo83.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo83.backboard.entity.Board;

// 인터페이스만 있어고 CRUD 가능
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
