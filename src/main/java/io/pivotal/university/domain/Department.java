package io.pivotal.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Department")
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Courses> courses = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourses(Courses course){
        courses.add(course);
    }

   /* @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }*/

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
