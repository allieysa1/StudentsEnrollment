package com.project.studentsenrollment.controller;

import com.project.studentsenrollment.model.Course;
import com.project.studentsenrollment.model.CourseStudent;
import com.project.studentsenrollment.model.Student;
import com.project.studentsenrollment.repository.CourseRepository;
import com.project.studentsenrollment.repository.CourseStudentRepository;
import com.project.studentsenrollment.repository.StudentRepository;
import com.project.studentsenrollment.repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "list-course";
    }

    @GetMapping("signup")
    public String showSignUpForm(Course course, Model model){

        model.addAttribute("teachers", teacherRepository.findAll());
        return "add-course";
    }

    @PostMapping("add")
        public String addStaff(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }

        courseRepository.save(course);
        return "redirect:list";
    }

    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "choose-course-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Course course = courseRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course", course);
        model.addAttribute("teachers", teacherRepository.findAll());
        return "update-course";
    }

    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setCourseId((int) id);
            return "index";
        }

        model.addAttribute("courses", courseRepository.findAll());
        courseRepository.save(course);
        return "list-course";
    }

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "choose-course-to-delete";
    }


    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable("id") long id, Model model) {
        Course course = courseRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));

        courseRepository.delete(course);
        model.addAttribute("courses", courseRepository.findAll());

        return "list-course";
    }
    // Assign Project= student to Staff=course

    @GetMapping("assign")
    public String assignStaffProject(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "choose-student-to-assign";
    }
    @GetMapping("assign/{id}")
    public String showAssignProjectForm(@PathVariable("id") long id, @Valid CourseStudent courseStudent
            , Model model) {
        Course course= courseRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course", course);
        model.addAttribute("students", studentRepository.findAll());

        return "assign-student";
    }
    @PostMapping("staffproject/{courseid}")
    public String updateStaffProject(@PathVariable("courseid") long id1, @Valid Student stud, @RequestParam String startDate,
                                     @RequestParam String grade, @Valid CourseStudent courseStudent,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            courseStudent.setId();
            return "index";
        }

        Course course = courseRepository.findCourseById((int) id1);
        Student student = studentRepository.findStudentById(stud.getStudentId());

        CourseStudent courseStudent1 = new CourseStudent(course,student,startDate,grade);
        courseStudentRepository.save(courseStudent1);

        return "index";
    }

    @GetMapping("display")
    public String displayStaffProject(Model model) {
        model.addAttribute("courses", courseRepository.findAll());

        return "choose-student-to-display";
    }
    @GetMapping("display/{staffid}")
    public String showDisplayProjectForm(@PathVariable("staffid") long id, Model model) {
        List<CourseStudent> courseStudent = (List<CourseStudent>) courseStudentRepository.findCourseStudentByCourseId((int) id);
        //     .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("courses", courseRepository.findCourseById((int)id));
        model.addAttribute("courseStudents", courseStudent);

        return "display-student";
    }

}