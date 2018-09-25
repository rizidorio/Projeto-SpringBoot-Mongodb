package com.ricardoizidorio.springbootmongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoizidorio.springbootmongodb.domain.Post;
import com.ricardoizidorio.springbootmongodb.repository.PostRepository;
import com.ricardoizidorio.springbootmongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));	
	}

}
