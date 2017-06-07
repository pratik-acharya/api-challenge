package com.disney.studios;

import com.disney.studios.domain.Breed;
import com.disney.studios.domain.Picture;
import com.disney.studios.domain.User;
import com.disney.studios.service.BreedService;
import com.disney.studios.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Bootstraps the Spring Boot com.disney.studios.Application
 *
 * Created by fredjean on 9/21/15.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(UserService userService, BreedService breedService){
        return  (args)->{
                            userService.save(new User("Pratik"));
                            userService.save(new User("Symbol"));

                            Arrays.asList("labrador","pug","retriever","yorkie")
                                    .forEach(
                                            (breed)->{
                                                Breed breedData = new Breed(breed);
                                                List<Picture> pictures = new ArrayList<>();
                                                try(Scanner scanner = new Scanner(new ClassPathResource("data/"+breed+".txt").getFile())){

                                                    while (scanner.hasNextLine()){
                                                        pictures.add(new Picture(scanner.nextLine(),breedData));

                                                    }

                                                    breedData.setPictures(pictures);
                                                    breedService.save(breedData);
                                                }catch (IOException e){
                                                    e.printStackTrace();
                                                }

                                            }
                                    );



        };

    }
}
