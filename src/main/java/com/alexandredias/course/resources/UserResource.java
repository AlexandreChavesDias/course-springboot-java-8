package com.alexandredias.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandredias.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "alexandre", "acd@hotmail", "51997370819", "12345");
		return ResponseEntity.ok().body(u);
	}
}
