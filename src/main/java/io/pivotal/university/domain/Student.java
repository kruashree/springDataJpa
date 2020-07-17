package io.pivotal.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private boolean fullTime;
    @Column
    private Integer age;
    @Embedded
    private Person person;
    @OneToMany
    private List<Courses> courses = new ArrayList<>();

    public Student() {
    }

    public Student(boolean fullTime, Integer age, Person person, List<Courses> courses) {
        this.fullTime = fullTime;
        this.age = age;
        this.person = person;
        this.courses = courses;
    }

    public Student(Person attendee, boolean fullTime, Integer age) {
        this.person = attendee;
        this.fullTime = fullTime;
        this.age = age;
        courses = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

  @Override
    public String toString() {
       /* return "Student{" +
                "id=" + id +
                ", fullTime=" + fullTime +
                ", age=" + age +
                ", person=" + person +
                ", courses=" + courses +
                '}';*/

      return "Student{" + "studentId=" + id + ", " +" person=" + person +", fullTime=" + fullTime +
              ", age=" + age + "}\n";
    }


}
