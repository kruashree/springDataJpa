package io.pivotal.university;

import io.pivotal.university.repo.CoursesRepository;
import io.pivotal.university.repo.DepartmentRepository;
import io.pivotal.university.repo.StaffRepository;
import io.pivotal.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDemos {

    @Autowired
    StudentRepository studentRepository;

   /* @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    CoursesRepository coursesRepository;*/

    @Test
    public void simpleQueryExamples() {

        System.out.println("\nFind 20 year old students");
        studentRepository.findByAge(20).forEach(System.out::println);
        System.out.println("\nFind full time old students");
        studentRepository.findByStudentFirstName("krupa").forEach(System.out::println);
        System.out.println("\nFind students with 'doe' as last name");
        studentRepository.findByStudentLastName("doe").forEach(System.out::println);
    }


}
