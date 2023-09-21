package com.springboot.studentId.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ravi=new Student(
                    "ravi",
                    "ravikumar@gmail.com",
                    LocalDate.of(1991,1,30)
            ) ;
            Student rani=new Student(
                    "rani",
                    "ranikumari@gmail.com",
                    LocalDate.of(2000,9,30)
            ) ;
            repository.saveAll(
                    List.of(ravi,rani)
            );


        };
    }

}
