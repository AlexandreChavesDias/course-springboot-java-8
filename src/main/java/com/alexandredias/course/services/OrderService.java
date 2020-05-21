package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.Order;
import com.alexandredias.course.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired//spring faz a injeção de dependencia 
	private OrderRepository repository;
	
	public List<Order> findAll(){//repassa a chamada para o repository.findAll
		return repository.findAll();
}
	public Order findById(Long id) {
		Optional <Order> obj = repository.findById(id);
		return obj.get();
	}
}
