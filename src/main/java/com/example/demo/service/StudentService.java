package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class StudentService {

    private StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getStudents() { return studentRepository.findAll();}

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
        }
    public void add(Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        Optional<Student> student =  studentRepository.findById(id);
        if (student.isPresent()){
            studentRepository.delete(student.get());
        }
    }

    public Student updateStudent(Long id, Student student){
    Optional<Student> studentToUpdateOptional = studentRepository.findById(id);
        if (studentToUpdateOptional.isPresent()) {
        Student studentToUpdate = studentToUpdateOptional.get();
        studentToUpdate.setNume(student.getNume());
        studentToUpdate.setPrenume(student.getPrenume());
        return studentRepository.save(studentToUpdate);
    }
        logger.info("lipsa student");
        return null;
    }
}

