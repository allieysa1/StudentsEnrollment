package com.project.studentsenrollment.model;

import jakarta.persistence.*;

@Entity
public class CourseStudent {

    @EmbeddedId
    private CourseStudentId id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_Id")
    private Course course;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_Id")
    private Student student;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "grade")
    private String grade;

    public CourseStudent() {
    }

    public CourseStudent(Course course, Student student, String startDate, String grade) {
        this.id = new CourseStudentId(course.getCourseId(),student.getStudentId());
        this.course = course;
        this.student = student;
        this.startDate = startDate;
        this.grade = grade;
    }

    public CourseStudentId getId() {
        return id;
    }

    public void setId() {
        this.id = new CourseStudentId(course.getCourseId(),student.getStudentId());
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", startDate='" + startDate + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
