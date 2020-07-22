package io.pivotal.university;

import io.pivotal.university.domain.*;
import io.pivotal.university.repo.CoursesRepository;
import io.pivotal.university.repo.DepartmentRepository;
import io.pivotal.university.repo.StaffRepository;
import io.pivotal.university.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

/*
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
        }*/
@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UniversityApplication.class);
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    CoursesRepository coursesrepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        //Students

        studentRepository.save(new Student(true, 20, "jane", "doe"));
        studentRepository.save(new Student(true, 22, "john","doe"));
        studentRepository.save(new Student(true, 18, "mike", "smith"));
        studentRepository.save(new Student(true, 19, "ally","smith"));
        studentRepository.save(new Student(true, 9, "dheeraj", "vijay"));
        studentRepository.save(new Student(true, 35, "krupa","shree"));

        log.info(" Student details");
        log.info(" *************************** ");
        for(Student student: studentRepository.findAll()){
            log.info(student.toString());
        }

        log.info(" Student less than 10 years \n *******************");
        List<Student> studentList  =studentRepository.findByAgeLessThan(10);
        studentList.forEach(System.out::println);

        log.info(" Student to display only last Name\n ------------------");
        for(Student student: studentRepository.findByStudentLastName("smith")){
            System.out.println(student.getStudentFirstName() +"  "+ student.getStudentLastName());
        }
        log.info(" Display student order by Age descending order\n **********************");
        for( Student student : studentRepository.findTop3ByOrderByAgeDesc()){
            log.info(student.toString());
        }


       Staff deanJones = staffRepository.save(new Staff("John","Jones"));
       Staff deanMartin = staffRepository.save(new Staff("Matthew","Martin"));
       Staff profBrown =   staffRepository.save(new Staff ("James", "Brown"));
       Staff profMiller =   staffRepository.save(new Staff("Judy", "Miller"));
       Staff profDavis =   staffRepository.save(new Staff("James", "Davis"));
       Staff profMoore =   staffRepository.save(new Staff ("Allison", "Moore"));
       Staff profThomas =   staffRepository.save(new Staff("Tom", "Thomas"));
       Staff profGreen =   staffRepository.save(new Staff ("Graham", "Green"));
       Staff profWhite=   staffRepository.save(new Staff("Whitney", "White"));
       Staff profBlack =   staffRepository.save(new Staff("Jack", "Black"));
       Staff profKing =   staffRepository.save(new Staff("Queen", "King"));
        log.info(" staff details");
        log.info(" *************************** ");
        for(Staff staff: staffRepository.findAll()){
            log.info(staff.toString());
        }

        log.info(" Staff Count is : "+staffRepository.count());



       //Departments
       Department humanities = departmentRepository.save(new Department("Humanities", deanJones));
       Department naturalSciences = departmentRepository.save(new Department("Natural Sciences", deanMartin));
       Department socialSciences = departmentRepository.save(new Department("Social Sciences", deanJones));


       //Humanities Courses
       Courses english101 = coursesrepository.save(new Courses("English 101", 3, profBlack, humanities));
       Courses english202 = coursesrepository.save(new Courses("English 202", 3, profBlack, humanities));
       coursesrepository.save(english202.addPrerequisite(english101));
       Courses english201 = coursesrepository.save(new Courses("English 201", 3, profBrown, humanities));
        coursesrepository.save(english201.addPrerequisite(english101));

       //Natural Science Courses
       Courses chemistry = coursesrepository.save(new Courses("Chemistry",3, profDavis, naturalSciences));
       Courses physics = coursesrepository.save(new Courses("Physics",3, profDavis, naturalSciences));
       coursesrepository.save(physics.addPrerequisite(chemistry));
       Courses cProgramming = coursesrepository.save(new Courses("C Programming",3, profMoore, naturalSciences));
       Courses jProgramming = coursesrepository.save(new Courses("Java Programming",3, profMoore, naturalSciences));

       //Social Science Courses
       Courses history101 = coursesrepository.save(new Courses("History 101",3, profMiller, socialSciences));
       Courses anthro = coursesrepository.save(new Courses("Anthropology ",3, profKing, socialSciences));
       coursesrepository.save(anthro.addPrerequisite(history101));
       Courses sociology = coursesrepository.save(new Courses("Sociology",3, profKing, socialSciences));
       coursesrepository.save(sociology.addPrerequisite(history101));
       Courses psych = coursesrepository.save(new Courses("Psychology",3, profWhite, socialSciences));
       coursesrepository.save(psych.addPrerequisite(history101).addPrerequisite(english101));

    }
}
