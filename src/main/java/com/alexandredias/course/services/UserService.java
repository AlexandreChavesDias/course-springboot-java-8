package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.User;
import com.alexandredias.course.repositories.UserRepository;

@Service
public class UserService {
	@Autowired//spring faz a injeção de dependencia 
	private UserRepository repository;
	
	public List<User> findAll(){//repassa a chamada para o repository.findAll
		return repository.findAll();
}
	public User findById(Long id) {
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}
}
