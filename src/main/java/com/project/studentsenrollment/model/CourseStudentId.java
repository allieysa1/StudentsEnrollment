package com.project.studentsenrollment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseStudentId implements Serializable {

    @Column(name = "course_Id")
    private Integer courseId;

    @Column(name = "student_Id")
    private Integer studentId;

    public CourseStudentId() {
    }

    public CourseStudentId(Integer courseId, Integer studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudentId that = (CourseStudentId) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId,
                that.studentId);
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CourseStudentId that = (CourseStudentId) o;
//
//        if (courseId == null || that.courseId == null) return false;
//        if (studentId == null || that.studentId == null) return false;
//
//        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
//    }


    @Override
    public int hashCode() {

        return Objects.hash(courseId, studentId);
    }
}
