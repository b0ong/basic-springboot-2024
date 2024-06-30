package com.hugo83.backboard.repository;

import com.hugo83.backboard.entity.Reset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResetRepository extends JpaRepository<Reset, Integer> {

    Optional<Reset> findByUuid(String uuid); // UUID로 테이브 검색
}
