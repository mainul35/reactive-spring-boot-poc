package com.mainul35.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainul35.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
	
	List<User> users = new ArrayList<>();
	
	public UserController() {
		// TODO Auto-generated constructor stub
		
		users.add(User.builder()
		        .uuid(UUID.randomUUID().toString())
		        .username("mainul35")
		        .password("test")
		        .email("mainuls18@gmail.com")
		        .build());
		
		users.add(User.builder()
		        .uuid(UUID.randomUUID().toString())
		        .username("mainul36")
		        .password("test")
		        .email("mainuls19@gmail.com")
		        .build());
	}
	
    @GetMapping
    public Flux<User> findAll() {
        return Mono.just(users).flatMapMany(Flux::fromIterable);
    }

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable("username") final String username) {
		var userOptional = users.stream().filter(user1 -> user1.getUsername().equals(username)).findAny();

		return userOptional.map(Mono::just).orElseGet(Mono::empty);
	}
    
    @PostMapping
    public Mono<User> create(@RequestBody final User user){
		user.setUuid(UUID.randomUUID().toString());
		users.add(user);
    	return Mono.just(user);
    }
    
    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") final String id, @RequestBody final User user){
		var user1 = users.stream().filter(u -> u.getUuid().equals(id)).map(u -> {
			BeanUtils.copyProperties(user, u);
			return u;
		}).findFirst().get();
    	return Mono.just(user1);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") final String id) {
		users.removeIf(u -> u.getUuid().equals(id));
    	return Mono.empty();
    }

    @GetMapping("/me")
    public Mono<User> getUser() {
    	return Mono.just(users.get(0));
    }
}
