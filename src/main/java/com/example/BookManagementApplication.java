package com.example;

import com.example.domain.Book;
import com.example.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookRepository bookRepository) {
		return args -> {
			for (int i = 0; i < 1000; i++) {
				Book book = new Book();
				book.setTitle("Book " + i);
				book.setAuthor(Arrays.asList("author1", "author2", "author3"));
				book.setIsbn("isbn" + i);
				book.setPublishYear(i + 2000);
				book.setTags(Arrays.asList("tag" + i, "tag2" + i));

				bookRepository.save(book);
			}
		};
	}

}
