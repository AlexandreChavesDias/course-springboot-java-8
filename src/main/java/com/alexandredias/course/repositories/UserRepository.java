package com.alexandredias.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandredias.course.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
