package com.ricardoizidorio.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoizidorio.springbootmongodb.domain.User;
import com.ricardoizidorio.springbootmongodb.dto.UserDTO;
import com.ricardoizidorio.springbootmongodb.repository.UserRepository;
import com.ricardoizidorio.springbootmongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));	
	}

	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO (UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
