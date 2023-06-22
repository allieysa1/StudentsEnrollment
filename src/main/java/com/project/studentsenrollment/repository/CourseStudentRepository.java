package com.project.studentsenrollment.repository;


import com.project.studentsenrollment.model.CourseStudent;
import com.project.studentsenrollment.model.CourseStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, CourseStudentId> {

    @Query(value = "SELECT * FROM course_student where course_id = :id", nativeQuery = true)
    List<CourseStudent> findCourseStudentByCourseId(@Param("id") int id);
}
