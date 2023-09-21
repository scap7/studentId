package com.springboot.studentId.student;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student){
        Optional<Student> studentOptional=studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
            studentRepository.save(student);
    }
    public void deleteStudentById(Long studentId){
        boolean exists=studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with Id: "+studentId+" does not exists");
        }
        studentRepository.deleteById(studentId);
    }
@Transactional
    public void updateStudent(Long studentId,String name,String email) {
           Student student= studentRepository.findById(studentId)
                   .orElseThrow(()->new IllegalStateException("student with Id: "+studentId+ "does not exists"));
           if(!Objects.equals(name, student.getName()) &&name!=null){
               student.setName(name);
           }
           if(!Objects.equals(email, student.getEmail()) &&email!=null){
               Optional<Student>studentOptional =studentRepository.findStudentByEmail(email);
              if(studentOptional.isPresent()) {
                  throw new IllegalStateException("email already taken");
              }student.setEmail(email);

           } 
    }

}

