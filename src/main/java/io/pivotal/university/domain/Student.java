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

    @Column
    private String studentFirstName;

    @Column
    private String studentLastName;


    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Courses> courses = new ArrayList<>();

    public Student() {
    }


    public Student(boolean fullTime, Integer age, String studentFirstName, String studentLastName) {
        this.fullTime = fullTime;
        this.age = age;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullTime=" + fullTime +
                ", age=" + age +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                '}';
    }
}
