package com.hugo83.backboard.repository;

import com.hugo83.backboard.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByTitle(String title); // select * from Category where title = :title;
}
