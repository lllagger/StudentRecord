package com.DockerExampleMondoDB.Service;

import com.DockerExampleMondoDB.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);
    Student updateStudent(Student student);

    List<Student> getAllStudent();
    void deleteStudent(String id);
}
