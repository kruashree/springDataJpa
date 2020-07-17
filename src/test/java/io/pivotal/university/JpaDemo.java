package io.pivotal.university;

import io.pivotal.university.domain.Department;
import io.pivotal.university.repo.DepartmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class JpaDemo {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void runJpaMethod(){

        departmentRepository.save(new Department("Development"));

        departmentRepository.saveAndFlush(new Department("Testing"));

        departmentRepository.save(new Department("Build and Release"));
        departmentRepository.flush();

        System.out.println("\n*************display all Departments*************");

        departmentRepository.findAll().forEach(System.out::println);

        departmentRepository.deleteInBatch(departmentRepository.findAll().subList(0,1));

        System.out.println("\n*************1 Less Departments*************");
        departmentRepository.findAll().forEach(System.out::println);
        departmentRepository.deleteAllInBatch();
        System.out.println("\n*************Zero Departments*************");
        departmentRepository.findAll().forEach(System.out::println);
    }

    @Before
    @After
    public void banner() {
        System.out.println("\n\n-------------------------------------------------" +
                "-------------------------------------\n");
    }
}
