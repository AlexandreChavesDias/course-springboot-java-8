package com.alexandredias.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alexandredias.course.entities.User;
import com.alexandredias.course.repositories.UserRepository;
import com.alexandredias.course.services.exceptions.DatabaseException;
import com.alexandredias.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired // spring faz a injeção de dependencia
	private UserRepository repository;

	public List<User> findAll() {// repassa a chamada para o repository.findAll
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);// findById busca no DB o objeto
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	// Operações DB

	// insere
	public User insert(User obj) {
		return repository.save(obj); // obj salvo
	}

	// delete
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	// atualizar
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);// prepara o obj monitorado para mexer e depois alterar no DB
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
