package com.project.studentsenrollment.model;
import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;


    public Course() {
    }

    public Course(String cname, Integer credit, String department, Teacher teacher) {
        this.cname = cname;
        this.credit = credit;
        this.department = department;
        this.teacher = teacher;
    }

    @Column(name = "course_name")
    private String cname;

    @Column(name = "course_credit")
    private Integer credit;

    @Column(name = "department")
    private String department;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", cname='" + cname + '\'' +
                ", credit='" + credit + '\'' +
                ", department=" + department +
                '}';
    }
}