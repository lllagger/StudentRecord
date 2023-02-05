package com.DockerExampleMondoDB.Service;

import com.DockerExampleMondoDB.Entity.Student;
import com.DockerExampleMondoDB.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student updateStudent(Student student) {
        Optional<Student> optionalStudent = this.studentRepository.findStudentByEmail(student.getEmail());

        if (optionalStudent.isPresent()) {
            Student studentUpdate = optionalStudent.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setFirstName(student.getFirstName());
            studentUpdate.setLastName(student.getLastName());
            studentUpdate.setEmail(student.getEmail());
            studentUpdate.setGender(student.getGender());
            studentUpdate.setAddress(student.getAddress());
            studentUpdate.setFavouriteSubjects(student.getFavouriteSubjects());
            studentUpdate.setTotalSpentInBooks(student.getTotalSpentInBooks());
            return studentUpdate;
        } else {
            System.out.println("E-mail kayıdı bulunamadı. Email :" + student.getEmail());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(String email) {
        Optional<Student> optionalStudent = this.studentRepository.findStudentByEmail(email);

        if (optionalStudent.isPresent()) {
            this.studentRepository.delete(optionalStudent.get());
        }else {
            System.out.println("İlgili e-maile ait kayıt bulunamadı.");
        }

    }
}
