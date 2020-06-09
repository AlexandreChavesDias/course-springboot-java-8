package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.Category;
import com.alexandredias.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired//injeção de dependencia 
	private CategoryRepository repository;
	
	public List<Category> findAll(){//repassa a chamada para o repository.findAll
		return repository.findAll();
}
	public Category findById(Long id) {
		Optional <Category> obj = repository.findById(id);
		return obj.get();
	}
}
