package com.alexandredias.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandredias.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
