package com.alexandredias.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandredias.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
