package com.DockerExampleMondoDB.Controller;

import com.DockerExampleMondoDB.Entity.Student;
import com.DockerExampleMondoDB.Service.StudentService;
import com.DockerExampleMondoDB.Service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("get/students")
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudent();
    }

    @PostMapping("create/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(this.studentService.createStudent(student));
    }

    @PutMapping("update/student/{email}")
    public ResponseEntity<Student> updateStudent(@PathVariable String email, @RequestBody Student student){
        student.setEmail(email);
        return ResponseEntity.ok().body(this.studentService.updateStudent(student));
    }

    @DeleteMapping("delete/student/{email}")
    public HttpStatus deleteStudent(@PathVariable String email){
        this.studentService.deleteStudent(email);
        return HttpStatus.OK;
    }

}
