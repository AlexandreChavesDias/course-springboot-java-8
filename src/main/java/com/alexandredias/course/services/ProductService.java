package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.Product;
import com.alexandredias.course.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired//spring faz a injeção de dependencia 
	private ProductRepository repository;
	
	public List<Product> findAll(){//repassa a chamada para o repository.findAll
		return repository.findAll();
}
	public Product findById(Long id) {
		Optional <Product> obj = repository.findById(id);
		return obj.get();
	}
}
