package io.pivotal.university.domain;

import javax.persistence.*;

@Entity
@Table(name ="Staff")
public class Staff {

    @Id
    @GeneratedValue
    private Integer staffId;

    @Column
    private String staffFirstName;
    @Column
    private String staffLastName;

    public Staff() {
    }

    public Staff( String staffFirstName, String staffLastName) {

        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = staffLastName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffFirstName='" + staffFirstName + '\'' +
                ", staffLastName='" + staffLastName + '\'' +
                '}';
    }
}
