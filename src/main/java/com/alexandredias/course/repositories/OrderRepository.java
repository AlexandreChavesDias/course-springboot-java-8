package com.alexandredias.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandredias.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
