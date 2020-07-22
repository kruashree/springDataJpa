package io.pivotal.university.view;

public class CourseView {

    private String name;
    private String instructorLastName;
    private String deptName;

    public CourseView(String name, String instructorLastName, String deptName) {
        this.name = name;
        this.instructorLastName = instructorLastName;
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "CourseView{" +
                "name='" + name + '\'' +
                ", instructorLastName='" + instructorLastName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
