package com.ricardoizidorio.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardoizidorio.springbootmongodb.domain.Post;
import com.ricardoizidorio.springbootmongodb.domain.User;
import com.ricardoizidorio.springbootmongodb.dto.AuthorDTO;
import com.ricardoizidorio.springbootmongodb.repository.PostRepository;
import com.ricardoizidorio.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Alice", "maria@gmail.com");
		User carlos = new User(null, "Carlos Brito", "carlos@gmail.com");
		User luiz = new User(null, "Luiz Claudio", "luiz@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, carlos, luiz));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Fui ali", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/03/2018"), "Bom dia!", "Semana começando!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
