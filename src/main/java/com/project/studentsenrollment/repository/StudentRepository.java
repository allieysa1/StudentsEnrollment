package com.project.studentsenrollment.repository;

import com.project.studentsenrollment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student where student_id = :id", nativeQuery = true)
    Student findStudentById(@Param("id") int id);
}
