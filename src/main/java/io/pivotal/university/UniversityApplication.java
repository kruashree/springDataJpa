package io.pivotal.university;

import io.pivotal.university.domain.Person;
import io.pivotal.university.domain.Student;
import io.pivotal.university.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class UniversityApplication {
    private static final Logger log = LoggerFactory.getLogger(UniversityApplication.class);

    public static void main(String[] args){
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository) {
        return (args) -> {

            studentRepository.save(new Student(new Person("jane", "doe"), true, 20));
            studentRepository.save(new Student(new Person("john", "doe"), true, 22));
            studentRepository.save(new Student(new Person("mike", "smith"), true, 18));
            studentRepository.save(new Student(new Person("ally", "kim"), false, 19));
            studentRepository.save(new Student(new Person("krupa","shree"), false, 35));

            log.info(" Student details");
            log.info(" *************************** ");
            for(Student student: studentRepository.findAll()){
                log.info(student.toString());
            }

            log.info(" *************************** ");
            Optional<Student> student = studentRepository.findById(4);
            log.info(" 4th Student details");
            log.info(" *************************** ");
            log.info(student.toString());



        };
        }
}
