package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private AccountRepository accountRepository;

	public DemoApplication(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Bean
	CommandLineRunner account(AccountRepository accountRepository) {
		return args -> {
			accountRepository.deleteAll().subscribe(null,null,()->{
				Account admin = new Account("admin","123456",true);
				Account user = new Account("user","123456",false);
				List<Account> accountList = Arrays.asList(admin,user);
				Flux.fromIterable(accountList).toStream().forEach(accountRepository::save);
			});

			Flux<Account> accountFlux = accountRepository.findAll();
			accountFlux.subscribe(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

