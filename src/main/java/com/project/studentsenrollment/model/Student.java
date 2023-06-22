package com.project.studentsenrollment.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_Id")
    private Integer studentId;

    @Column(name = "student_name")
    private String studName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "student")
    private Set<CourseStudent> courseStudents = new HashSet<>();

    public Student() {
    }

        public Student(String studName, String email, Set<CourseStudent> courseStudents) {
        this.studName = studName;
        this.email = email;
        this.courseStudents = courseStudents;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CourseStudent> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(Set<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studName='" + studName + '\'' +
                ", email=" + email +
                ", courseStudents=" + courseStudents +
                '}';
    }
}
