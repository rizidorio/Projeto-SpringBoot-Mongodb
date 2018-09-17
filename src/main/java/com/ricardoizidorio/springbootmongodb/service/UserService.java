package com.ricardoizidorio.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoizidorio.springbootmongodb.domain.User;
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

}
