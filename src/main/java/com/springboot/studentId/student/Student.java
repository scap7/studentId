package com.springboot.studentId.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="student_sequence"
    )
    private Long studentId;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
     Student(){

    }
    public Student(Long studentId, String name, String email, LocalDate dob){
         this.studentId=studentId;
         this.name=name;
         this.email=email;
         this.dob=dob;
    }
    Student(String name,String email,LocalDate dob){
         this.name=name;
         this.email=email;
         this.dob=dob;

    }
    public  Long getStudentId(){
         return studentId;
    }
    public Integer getAge(){
         return Period.between(this.dob,LocalDate.now()).getYears();
    }
    public String getName(){
         return name;
    }
    public LocalDate getDob(){
         return dob;
    }
    public String getEmail(){
         return email;
    }
    public void setStudentId(Long studentId){
         this.studentId=studentId;

    }
    public void setAge(Integer age){
         this.age=age;
    }
    public void setName(String name){
         this.name=name;
    }
    public void setDob(LocalDate dob){
         this.dob=dob;
    }
    public void setEmail(String email){
         this.email=email;
    }
    @Override
    public String toString(){
         return ("studentId: "+studentId
                 + "name: "+ name
                 +"email: "+email
                 +"date of birth: "+dob
                 +"age: "+age);
    }


}
