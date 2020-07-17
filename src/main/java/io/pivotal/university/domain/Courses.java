package io.pivotal.university.domain;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn
    private Department department;

    public Courses(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Courses() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
