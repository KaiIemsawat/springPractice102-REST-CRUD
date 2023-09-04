package com.ApiDemo.demo.rest;

import com.ApiDemo.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

//    Create a list for students
    private List<Student> studentList;

//    define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
//        Initialize the student list
        studentList = new ArrayList<>();

        studentList.add(new Student("Zukkii", "Kiiii"));
        studentList.add(new Student("Titann", "Tann"));
        studentList.add(new Student("Stelbel", "Bellll"));
    }

//    define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
//    By default, path variable should be matched
    public Student getStudentById(@PathVariable int studentId) {

//        Custom Exception
//        Check the studentId against list size
        if (studentId >= studentList.size() || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return studentList.get(studentId);
    }
}
