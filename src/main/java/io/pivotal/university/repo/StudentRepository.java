package io.pivotal.university.repo;

import io.pivotal.university.domain.Person;
import io.pivotal.university.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    // Simple Queries
    List<Student> findByStudentFirstName(String firstName);
    List<Student> findByAge(Integer age);
    List<Student> findByStudentLastName(String lastName);

    // Queries with Clause and Expression
   // Student findByPerson(Person person);
    List<Student> findByAgeGreaterThan(int maximumAge);
    List<Student> findByAgeLessThan(int minimumAge);
    List<Student> findByStudentLastNameIgnoreCase(String lastName);
    List<Student> findByStudentLastNameLike(String likeString);
   // Student findFirstStudentByOrderByLastNameAsc();
    Student findTopByOrderByAgeDesc();
    List<Student> findTop3ByOrderByAgeDesc();
}
