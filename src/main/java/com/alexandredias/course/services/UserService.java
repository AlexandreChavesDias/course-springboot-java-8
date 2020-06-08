package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.User;
import com.alexandredias.course.repositories.UserRepository;

@Service
public class UserService {
	@Autowired // spring faz a injeção de dependencia
	private UserRepository repository;

	public List<User> findAll() {// repassa a chamada para o repository.findAll
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);// findById busca no DB o objeto
		return obj.get();
	}
	// Operações DB

	           // insere
	public User insert(User obj) {
		return repository.save(obj); // obj salvo
	}

               //delete
	public void delete(Long id) {
		repository.deleteById(id);
	}

         	// atualizar
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);// prepara o obj monitorado para mexer e depois alterar no DB
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
