package io.pivotal.university;

import io.pivotal.university.domain.Person;
import io.pivotal.university.domain.Student;
import io.pivotal.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest

public class CrudRepositoryDemo {
    @Autowired
    StudentRepository studentRepository;

    /**
     * Exercise CrudRepository methods.
     */
   // @Test
    public void simpleStudentCrudExample() {
        boolean fullTime = true;
        studentRepository.save(new Student(true, 20, "jane", "doe"));
        studentRepository.save(new Student(true, 22, "john","doe"));
        studentRepository.save(new Student(true, 18, "mike", "smith"));
        studentRepository.save(new Student(true, 19, "ally","kim"));
        studentRepository.save(new Student(true, 9, "dheeraj", "vijay"));

        System.out.println("\n*************Original Students*************");
        studentRepository.findAll().forEach(System.out::println);

        //age up the students
        studentRepository.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepository.save(student);
        });

        System.out.println("\n*************Students a year older*************");
        studentRepository.findAll().forEach(System.out::println);


        studentRepository.deleteAll();
        System.out.println("\n*************Students removed*************");
        studentRepository.findAll().forEach(System.out::println);

    }
}
