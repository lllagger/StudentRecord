package com.DockerExampleMondoDB;

import com.DockerExampleMondoDB.Entity.Address;
import com.DockerExampleMondoDB.Entity.Gender;
import com.DockerExampleMondoDB.Entity.Student;
import com.DockerExampleMondoDB.Repository.StudentRepository;
import com.DockerExampleMondoDB.Service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DockerExampleMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerExampleMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Türkiye", "İstanbul", "34");
            String email = "denizhan2@hotmail.com";
            Student student = new Student("Denizhan", "Yıldız", email, Gender.MALE, address, List.of("Bilgisayar bilimleri", "Matematik"), BigDecimal.TEN, LocalDateTime.now());
         //   Student student1 = new Student("Gökhan", "Türkeri", "gkhan@test.com", Gender.MALE, address, List.of("Bilgisayar bilimleri", "Fen Bilgisi"), BigDecimal.TEN, LocalDateTime.now());
         //   Student student2 = new Student("Mustafa", "Turan", "mustafa@test.com", Gender.MALE, address, List.of("Bilgisayar bilimleri", "Beden Eğitimi"), BigDecimal.TEN, LocalDateTime.now());
         //   Student student3 = new Student("Derya", "Kaya", "derya@test.com", Gender.FEMALE, address, List.of("Bilgisayar bilimleri", "Coğrafya"), BigDecimal.TEN, LocalDateTime.now());
         //   Student student4 = new Student("Ayşe", "Çırakman", "melike@test.com", Gender.FEMALE, address, List.of("Bilgisayar bilimleri", "İngilizce"), BigDecimal.TEN, LocalDateTime.now());

            studentRepository.findStudentByEmail(email)
                    .ifPresentOrElse(
                            s -> {
                                System.out.println("Öğrenci " + student.getFirstName() + " " + student.getLastName() + " sisteme önceden kaydedilmiş.");
                            },
                            () -> {
                                System.out.println("Öğrenci kaydediliyor.. Öğrenci bilgileri :" + student);
                                studentRepository.insert(student);
                            });
        };
    }


}
