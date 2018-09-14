package com.ricardoizidorio.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardoizidorio.springbootmongodb.domain.User;
import com.ricardoizidorio.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Alice", "maria@gmail.com");
		User carlos = new User(null, "Carlos Brito", "carlos@gmail.com");
		User luiz = new User(null, "Luiz Claudio", "luiz@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, carlos, luiz));
	}

}
