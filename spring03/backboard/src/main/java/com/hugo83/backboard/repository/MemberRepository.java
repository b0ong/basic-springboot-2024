package com.hugo83.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo83.backboard.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
