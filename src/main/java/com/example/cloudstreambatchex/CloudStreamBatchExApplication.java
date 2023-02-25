package com.example.cloudstreambatchex;

import com.example.cloudstreambatchex.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class CloudStreamBatchExApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamBatchExApplication.class, args);
	}
	@Bean
	public Function<List<User>,List<String>> names (){
		return users-> users.stream().map(User::getName).collect(Collectors.toList());
	}
	@Bean
	public Function<List<String>,String> join(){
		return names->names.stream().collect(Collectors.joining(","));
	}
	@Bean
	public Function<String,String> upper(){
		return String::toUpperCase;
	}
	@Bean
	public Consumer<Object> print(){
		return System.out::println;
	}
	@Bean
	public Supplier<User> generate(){
		return ()-> new User("55","ramy",30);
	}
}
