package com.project.studentsenrollment.repository;

import com.project.studentsenrollment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    @Query(value = "SELECT * FROM course where course_id = :id", nativeQuery = true)
    Course findCourseById(@Param("id") int id);

}